package com.pagos;

import com.cableado.IRecaudo;

public class RealizarCompra implements IRecaudo {

	private Pagos pago;
	
	
	@Override
	public void realizarPago(int tipoPago, int Cantidad) {
		
		if(tipoPago==1) {
			pago = new Nequi();
		}else if(tipoPago==2) {
			pago = new Efecty();
		}
		else if(tipoPago==3) {
			pago = new Tarjeta();
		}
		
		pago.pagar(Cantidad);
		
	}
	
	

}
