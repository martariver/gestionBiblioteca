package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario create(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
