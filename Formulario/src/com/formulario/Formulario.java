package com.formulario;

import com.formulario.componentes.Componente;

public interface Formulario {
	
	void ingresar();
	void registrar();
	void registrarComponente(Componente componente);
	void ocultarElementos(boolean flag,String titulo);
	void createGUI();
}
