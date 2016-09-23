package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.service.interfaces.LibroService;

public class LibroServiceImp implements LibroService{

	@Autowired
	LibroDAOImp libDAO;
	
	@Override
	public List<Libro> getAll() {
		List<Libro> libros = null;
		libros= libDAO.getAll();
		
		return libros;
	}

	@Override
	public Libro getById(int id) {
		Libro lib = null;
		lib = libDAO.getById(id);
		
		return lib;
	}

	@Override
	public Libro update(Libro libro) {
		
		return libDAO.update(libro);
	}

	@Override
	public void delete(int id) {
		libDAO.delete(id);
		
	}

	@Override
	public Libro create(Libro libro) {
		
		return libDAO.create(libro);
	}

	@Override
	public void setLibDAO(LibroDAOImp libDAO) {
		this.libDAO=libDAO;
		
	}

}
