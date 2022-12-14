package com.formulario.componentes;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.formulario.Formulario;

public class Registrarse extends JButton implements Componente{

	private Formulario form;
	
	public Registrarse() {
		super("Registrarse");
	}
	
	@Override
	public void setMediador(Formulario form) {
		this.form=form;
	}
	
	@Override
	protected void fireActionPerformed(ActionEvent ae) {
		form.ocultarElementos(false,"Registro");;
	} 

	@Override
	public String getname() {
		return "Registrarse";
	}


}
