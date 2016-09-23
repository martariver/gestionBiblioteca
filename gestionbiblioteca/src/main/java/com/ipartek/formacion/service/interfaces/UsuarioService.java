package com.ipartek.formacion.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.persistencia.Usuario;

@Service
public interface UsuarioService {

	public List<Usuario> getAll();
	
	public Usuario getById(int id);
	
	public Usuario update(Usuario usuario);
	
	public void delete(int id);
	
	public Usuario create(Usuario usuario);
	
	public void setUsuDAO(UsuarioDAOImp usuDAO);
}
