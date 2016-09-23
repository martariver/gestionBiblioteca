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

import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.mapas.LibroMapper;
import com.ipartek.formacion.dao.persistencia.Libro;

public class LibroDAOImp implements LibroDAO{

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
	public List<Libro> getAll() {
		List<Libro> libros = null;
		final String SQL= "SELECT id,titulo,autor,ISBN FROM libro";
		try{
			libros = jdbctemplate.query(SQL, new LibroMapper());
		}catch(EmptyResultDataAccessException e){
			libros = new ArrayList<Libro>();
		}catch(Exception e){
			
		}
		return libros;
	}

	@Override
	public Libro getById(int id) {
		Libro libro = null;
		final String SQL = "SELECT id,titulo,autor,ISBN FROM libro WHERE id = ?";
		try{
			libro = jdbctemplate.queryForObject(SQL,new Object[] {id} , new LibroMapper());
		}catch(EmptyResultDataAccessException e){
			libro = new Libro();
		}
		return libro;
	}

	@Override
	public Libro update(Libro libro) {
		final String SQL = "UPDATE libro SET titulo = ? ,autor = ?, ISBN = ? WHERE id = ?";
		
		jdbctemplate.update(SQL,libro.getTitulo(),libro.getAutor(),libro.getISBN(),libro.getId());
		
		return libro;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM libro WHERE id = ?";
		
		jdbctemplate.update(SQL, new Object[] {id});
		
	}

	@Override
	public Libro create(Libro libro) {
		jdbcCall.withProcedureName("insertLibro");
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("titulo",libro.getTitulo() ).
				addValue("autor", libro.getAutor()).
				addValue("ISBN", libro.getISBN());
		
		Map<String, Object> out = jdbcCall.execute(in);
		
		libro.setId((Integer) out.get("id") );
		
		return libro;
	}

}
