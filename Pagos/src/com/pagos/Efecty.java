package com.pagos;

public class Efecty implements Pagos {
	@Override
	public void pagar(int precio) {
		System.out.println("Pago con Efecty: " +precio);
	}

}
