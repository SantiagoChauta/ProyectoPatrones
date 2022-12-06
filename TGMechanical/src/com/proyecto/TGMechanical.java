package com.proyecto;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.cableado.IRecaudo;
import com.cableado.ISesion;
import com.cableado.ITheGreatMechanical;
import com.utilidades.Cargador;

public class TGMechanical implements ITheGreatMechanical {

	public static void main(String[] args) {
		new TGMechanical().orquestarComponentes();
	}

	@Override
	public void orquestarComponentes() {

		Class cls = null;
		Class cls2 = null;
		
		Cargador2 crgFront = new Cargador2("../ProyectoPatrones/TGMechanical/front");
		Cargador2 crgBack = new Cargador2(
				"../ProyectoPatrones/TGMechanical/back");
		cls  = crgBack.getClase(IRecaudo.class.getName());
		cls2 = crgFront.getClase(ISesion.class.getName());

		try {

			final IRecaudo ie = (IRecaudo) cls.newInstance();
			ie.realizarPago(1,520000);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "No existe el componente Pagos");
			
		}
		
		try {
			ISesion form = (ISesion) cls2.newInstance();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No existe el componente Formulario");
			
		}

	}

}
