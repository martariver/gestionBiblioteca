package com.ipartek.formacion.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.persistencia.Libro;

@Service
public interface LibroService {

	public List<Libro> getAll();
	
	public Libro getById(int id);
	
	public Libro update(Libro libro);
	
	public void delete(int id);
	
	public Libro create(Libro libro);
	
	public void setLibDAO(LibroDAOImp libDAO);
}
