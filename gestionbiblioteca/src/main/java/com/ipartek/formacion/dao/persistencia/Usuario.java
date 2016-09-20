package com.ipartek.formacion.dao.persistencia;

import java.util.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String email;
	private String password;
	/**
	 * 
	 */
	public Usuario() {
		super();
		this.setId(-1);
		this.setNombre("");
		this.setApellidos("");
		this.setfNacimiento(new Date());
		this.setEmail("");
		this.setPassword("");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
