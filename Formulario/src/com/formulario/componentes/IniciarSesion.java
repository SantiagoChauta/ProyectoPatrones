package com.formulario.componentes;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.formulario.Formulario;

public class IniciarSesion extends JButton implements Componente{
	private Formulario form;
	
	public IniciarSesion() {
		super("Iniciar Sesion");
	}

	@Override
	public void setMediador(Formulario form) {
		this.form = form;
		
	}
	@Override
	protected void fireActionPerformed(ActionEvent ae) {
		form.ingresar();
	}
	
	@Override
	public String getname() {
		return "Iniciar Sesion";
	}
}
