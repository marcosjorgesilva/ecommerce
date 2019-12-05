package com.marcosjorge.projetojweb.resources;

import static org.junit.Assert.assertNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.marcosjorge.projetojweb.domain.Cliente;
import com.marcosjorge.projetojweb.domain.Endereco;
import com.marcosjorge.projetojweb.domain.Pedido;
import com.marcosjorge.projetojweb.services.PedidoService;

public class PedidoResourceTest {

	Cliente c;
	Endereco e;
	PedidoService sp = new PedidoService();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Date date = new Date();
	Pedido ped1 = new Pedido(null,date,c,e);
		
	@BeforeClass
	public void InsertService() {
		sp.insert(ped1);
	}
	
	@Test
	public void testDataPedido() {
		assertNull(sp.find(1).getDataPedido());
	}

}
