package com.cliente;

import java.util.List;

import com.cliente.Tablas.Cliente;
import com.cliente.Tablas.Pedido;
import com.cliente.implementaciones.ClienteDAOImp;
import com.cliente.implementaciones.PedidoDAOImp;

public class demo {
	public static void main(String[] args) {
		 
		ClienteDAOImp em = new ClienteDAOImp();
		PedidoDAOImp pDAO = new PedidoDAOImp();
		
		List<Pedido> l = em.listarPedidos("1111");
		for (Pedido a:l) {
			System.out.println(a.toString());
		}
	}
}
