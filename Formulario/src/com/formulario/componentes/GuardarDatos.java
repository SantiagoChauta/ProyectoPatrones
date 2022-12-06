package com.formulario.componentes;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.formulario.Formulario;

public class GuardarDatos extends JButton implements Componente{
	
	private Formulario form;
	
	public GuardarDatos() {
		super("Guardar Datos");
	}
	
	@Override
	public void setMediador(Formulario form) {
		this.form=form;
		
	}
	@Override
	protected void fireActionPerformed(ActionEvent ae) {
		form.registrar();
	}
	
	@Override
	public String getname() {
		return "Guardar Datos";
	}

}
