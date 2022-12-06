package com.cliente.DAO;

import java.util.List;

import com.cliente.Tablas.Cliente;
import com.cliente.Tablas.Pedido;

public interface ClienteDAO  {
	
	public Cliente findById(String id);
	public boolean actualizar(Cliente cliente);
	public boolean save(Cliente cliente);
	public boolean remove(String id);
	public List<Pedido> listarPedidos(String id);
	

}
