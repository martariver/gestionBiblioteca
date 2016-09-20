package com.ipartek.formacion.dao.persistencia;

public class Ejemplar {

	private int id;
	private String editorial;
	private int numPaginas;
	private int idLibro;
	/**
	 * 
	 */
	public Ejemplar() {
		super();
		this.setId(-1);
		this.setEditorial("");
		this.setNumPaginas(0);
		this.setIdLibro(0);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	
	
}
