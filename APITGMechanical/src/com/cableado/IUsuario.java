package com.cableado;

import java.util.List;

public interface IUsuario {
	void guardarDatosCliente(String nombre,String apellido,String cedula,String correo,String pass);
	Object consultarDatosCliente(String cedula);
	void guardarDatosPedidos(String cliente_id,String producto,float precio);
	Object consultarDatosPedidos(int datos);
	List<Object> listarPedidos(String cedula);
}
