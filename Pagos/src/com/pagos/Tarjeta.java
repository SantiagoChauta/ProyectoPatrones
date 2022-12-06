package com.pagos;

public class Tarjeta implements Pagos{

	@Override
	public void pagar(int precio) {
		System.out.println("Pago con tarjeta: " +precio);
	}

}
