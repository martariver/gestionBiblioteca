package com.ipartek.formacion.dao.mapas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Libro;

public class LibroMapper implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro libro = null;
		libro = new Libro();
		libro.setId(rs.getInt("id"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAutor(rs.getString("autor"));
		libro.setISBN(rs.getString("isbn"));
		
		return libro;
	}

}
