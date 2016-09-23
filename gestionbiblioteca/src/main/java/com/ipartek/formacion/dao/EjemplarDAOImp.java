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

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.mapas.EjemplarMapper;
import com.ipartek.formacion.dao.mapas.LibroMapper;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

public class EjemplarDAOImp implements EjemplarDAO{

	@Autowired
	private JdbcTemplate jdbctemplate;
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource); 
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		
	}

	@Override
	public List<Ejemplar> getAll() {
		List<Ejemplar> ejemplares = null;
		final String SQL= "SELECT id,editorial,numPaginas,idLibro FROM ejemplar";
		try{
			ejemplares = jdbctemplate.query(SQL, new EjemplarMapper());
		}catch(EmptyResultDataAccessException e){
			ejemplares = new ArrayList<Ejemplar>();
		}catch(Exception e){
			
		}
		return ejemplares;
	}

	@Override
	public Ejemplar getById(int id) {
		Ejemplar ejemplar = null;
		final String SQL = "SELECT id,editorial,numPaginas,idLibro FROM ejemplar WHERE id = ?";
		try{
			ejemplar = jdbctemplate.queryForObject(SQL,new Object[] {id} , new EjemplarMapper());
		}catch(EmptyResultDataAccessException e){
			ejemplar = new Ejemplar();
		}
		return ejemplar;
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		final String SQL = "UPDATE ejemplar SET editorial = ? ,numPaginas = ? WHERE id = ?";
		
		jdbctemplate.update(SQL,ejemplar.getEditorial(),ejemplar.getNumPaginas(),ejemplar.getId());
		return null;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM ejemplar WHERE id = ?";
		
		jdbctemplate.update(SQL, new Object[] {id});
		
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		jdbcCall.withProcedureName("insertEjemplar");
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("editorial",ejemplar.getEditorial() ).
				addValue("numPaginas", ejemplar.getNumPaginas());
		
		Map<String, Object> out = jdbcCall.execute(in);
		
		ejemplar.setId((Integer) out.get("id") );
		
		return ejemplar;
	}

}
