package com.cableado;

public interface ISesion {
	void iniciarSesion(String usuario,String password);
	void registrarse(String usuario,String Nombre, String Apellido, String Correo, String password);
}
