package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.service.interfaces.EjemplarService;

public class EjemplarServiceImp implements EjemplarService{

	@Autowired
	EjemplarDAO ejemDAO;
	
	@Override
	public List<Ejemplar> getAll() {
		List<Ejemplar> ejemplares = null;
		ejemplares = ejemDAO.getAll();
		
		return ejemplares;
	}

	@Override
	public Ejemplar getById(int id) {
		Ejemplar ejemplar = null;
		ejemplar=ejemDAO.getById(id);
		
		return ejemplar;
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		
		return ejemDAO.update(ejemplar);
	}

	@Override
	public void delete(int id) {
		ejemDAO.delete(id);
		
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		
		return ejemDAO.create(ejemplar);
	}

	@Override
	public void setEjemDAO(EjemplarDAOImp ejemDAO) {
		this.ejemDAO=ejemDAO;
		
	}

}
