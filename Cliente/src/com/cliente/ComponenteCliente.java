package com.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.cableado.IUsuario;
import com.cliente.Tablas.Cliente;
import com.cliente.Tablas.Pedido;
import com.cliente.implementaciones.ClienteDAOImp;
import com.cliente.implementaciones.PedidoDAOImp;

public class ComponenteCliente implements IUsuario {
	ClienteDAOImp em ;
	PedidoDAOImp pDAO;
	
	public ComponenteCliente() {
		em = new ClienteDAOImp();
		pDAO = new PedidoDAOImp();
	}

	@Override
	public void guardarDatosCliente(String nombre, String apellido, String cedula, String correo, String pass) {
		Cliente cl = new Cliente(cedula,nombre,apellido,correo,pass);
		em.save(cl);
		JOptionPane.showMessageDialog(null, "Datos guardados Con exito");
	}

	@Override
	public Object consultarDatosCliente(String cedula) {
		Cliente cl = em.findById(cedula);
		if(cl!=null) {
			return cl;
		}
		return null;
	}

	@Override
	public void guardarDatosPedidos(String cliente_id, String producto, float precio) {
		pDAO.save(new Pedido(cliente_id,producto,precio));	
	}

	@Override
	public Object consultarDatosPedidos(int datos) {
		Pedido p = pDAO.findById(datos);
		if(p!=null) {
			return p;
		}
		return null;
	}

	@Override
	public List<Object> listarPedidos(String cedula) {
		List<Pedido> list = em.listarPedidos(cedula);
		List<Object> lista=new ArrayList<>();
		for(Pedido p:list) {
			lista.add((Object)p);
		}
		return lista;
	}
	

}