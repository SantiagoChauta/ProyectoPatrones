package com.pagos;

public class Nequi implements Pagos{
	@Override
	public void pagar(int precio) {
		System.out.println("Pago con nequi: " +precio);
	}

}
