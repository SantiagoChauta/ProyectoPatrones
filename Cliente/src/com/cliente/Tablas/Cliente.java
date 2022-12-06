package com.cliente.Tablas;

import java.util.List;

public class Cliente {
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	
	public Cliente(){
		
	}
	
	
	public Cliente(String cedula, String nombre, String apellido, String correo, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cedula = cedula;
		this.password = password;
	}
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula=cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString(){
		return "Cliente: "+getNombre()+"\nApellido: "+getApellido()+"\nCorreo:"+getCorreo()+"\nCedula: "+getCedula()+"\nPassword: "+getPassword();
	}
	
	
}
