package com.cliente.Tablas;

public class Pedido {
	private int id;
	private String cliente_id;
	private String producto;
	private float precio;
	
	public Pedido() {
		
	}
	
	public Pedido(int id, String producto, float precio) {
		super();
		this.id = id;
		this.producto = producto;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}
	public String getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClienteId() {
		return cliente_id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	@Override
	public String toString() {
		return "ID: "+ id+"\nCliente_id: "+cliente_id+"\nProducto: "+producto +"\nPrecio:"+precio;
	}
	
	
}
