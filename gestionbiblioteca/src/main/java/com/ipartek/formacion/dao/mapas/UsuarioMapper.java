package com.ipartek.formacion.dao.mapas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Usuario;

public class UsuarioMapper implements RowMapper<Usuario>{
	@Override
	public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
		Usuario usuario = null;
		usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setfNacimiento(rs.getDate("fNacimiento"));
		usuario.setEmail(rs.getString("email"));
		usuario.setPassword(rs.getString("password"));
		
		return usuario;
	}
}
