package com.formulario.componentes;

import javax.swing.JTextField;

import com.formulario.Formulario;

public class Apellido extends JTextField implements Componente {

	private Formulario form;
	
	@Override
	public void setMediador(Formulario form) {
		this.form=form;
		
	}

	@Override
	public String getname() {
		return "Apellido";
	}

}
