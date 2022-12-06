package com.cableado;

public interface IComunidad {
	void publicarOpinion(String Mensaje);
	void borrarOpinion(int id);
	void editarOpinion(int id, String mensaje);
	void cargarOpiniones();
}
