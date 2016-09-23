package com.ipartek.formacion.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.persistencia.Ejemplar;

@Service
public interface EjemplarService {
	
	public List<Ejemplar> getAll();
	
	public Ejemplar getById(int id);
	
	public Ejemplar update(Ejemplar ejemplar);
	
	public void delete(int id);
	
	public Ejemplar create(Ejemplar ejemplar);
	
	public void setEjemDAO(EjemplarDAOImp ejemDAO);
}
