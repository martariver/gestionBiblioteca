package com.ipartek.formacion.dao.mapas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Ejemplar;

public class EjemplarMapper implements RowMapper<Ejemplar>{

	@Override
	public Ejemplar mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ejemplar ejemplar = null;
		ejemplar = new Ejemplar();
		ejemplar.setId(rs.getInt("id"));
		ejemplar.setEditorial(rs.getString("editorial"));
		ejemplar.setNumPaginas(rs.getInt("numPaginas"));
		ejemplar.setIdLibro(rs.getInt("id_libro")); //fk id libro
		
		return ejemplar;
	}

}
