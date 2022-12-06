package com.formulario.componentes;

import javax.swing.JLabel;

import com.formulario.Formulario;

public class Titulo extends JLabel implements Componente{

	private Formulario form;
	
	@Override
	public void setMediador(Formulario form) {
		this.form =form;
		
	}
	

	@Override
	public String getname() {
		return "Titulo";
	}

}
