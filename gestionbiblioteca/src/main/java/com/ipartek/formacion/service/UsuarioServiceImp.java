package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	UsuarioDAO usuDAO;
	
	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		usuarios= usuDAO.getAll();
		
		return usuarios;
	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		usuario= usuDAO.getById(id);
		
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		Usuario usu = null;
		usu = usuDAO.update(usuario);
		
		return usu;
	}

	@Override
	public void delete(int id) {
		usuDAO.delete(id);
		
	}

	@Override
	public Usuario create(Usuario usuario) {
		
		return usuDAO.create(usuario);
	}

	@Override
	public void setUsuDAO(UsuarioDAOImp usuDAO) {
		this.usuDAO = usuDAO;
		
	}

}
