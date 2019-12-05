package com.marcosjorge.projetojweb.services;


import org.junit.Assert;
import org.junit.Test;

import com.marcosjorge.projetojweb.domain.Pedido;

public class PedidoServiceTest {

	@Test
	public void test() {
		
		PedidoService service = new PedidoService();
	
		//Açao
		Pedido pedido = service.find(1);
		
		//Verificação
		Assert.assertTrue(pedido.getValorTotal() == 200.00);
		Assert.assertEquals(pedido.getCliente(), 1);
	}

}
