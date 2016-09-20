package com.ipartek.formacion.dao.persistencia;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;
	private String ISBN;
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
	
	

}
