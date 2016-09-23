package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.mapas.UsuarioMapper;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class UsuarioDAOImp implements UsuarioDAO{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource); 
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		final String SQL= "SELECT id,nombre,apellidos,fNacimiento,email,password FROM usuario";
		try{
			usuarios = jdbctemplate.query(SQL, new UsuarioMapper());
		}catch(EmptyResultDataAccessException e){
			usuarios = new ArrayList<Usuario>();
		}catch(Exception e){
			
		}
		return usuarios;
	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		final String SQL = "SELECT id, nombre, apellidos,fNacimiento,email,password FROM usuario WHERE id = ?";
		try{
			usuario = jdbctemplate.queryForObject(SQL,new Object[] {id} , new UsuarioMapper());
		}catch(EmptyResultDataAccessException e){
			usuario = new Usuario();
		}
		
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		final String SQL = "UPDATE usuario SET nombre = ? ,apellidos = ?, fNacimiento = ?, email = ?, password = ? WHERE id = ?";
		
		jdbctemplate.update(SQL,usuario.getNombre(),usuario.getApellidos(),usuario.getfNacimiento(),usuario.getEmail(),usuario.getPassword(),usuario.getId());
		
		
		return usuario;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM usuario WHERE id = ?";
		
		jdbctemplate.update(SQL, new Object[] {id});
		
	}

	@Override
	public Usuario create(Usuario usuario) {
		
		jdbcCall.withProcedureName("insertUsuario");
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("nombre",usuario.getNombre() ).
				addValue("apellidos", usuario.getApellidos()).
				addValue("fNacimiento", usuario.getfNacimiento()).
				addValue("email", usuario.getEmail()).
				addValue("password", usuario.getPassword());
		
		
		Map<String, Object> out = jdbcCall.execute(in);
		
		usuario.setId((Integer) out.get("id") );
		
		return usuario;
	}

}
