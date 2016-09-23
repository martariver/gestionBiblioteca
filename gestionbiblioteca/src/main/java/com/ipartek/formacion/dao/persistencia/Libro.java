package com.ipartek.formacion.dao.persistencia;

import java.util.List;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;
	private String ISBN;
	private List<Ejemplar> ejemplares;
	/**
	 * 
	 */
	public Libro() {
		super();
		this.setId(-1);
		this.setTitulo("");
		this.setAutor("");
		this.setISBN("");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}
	
	

}
