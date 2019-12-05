package com.marcosjorge.projetojweb.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

import com.marcosjorge.projetojweb.services.PedidoService;

import dbUnit.DbUnitProvider;

public class RepoPedidoTest {

	DbUnitProvider dbUnitProvider = new DbUnitProvider();
	PedidoService serv = new PedidoService();
	
	@Before
	public void inserirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Pedido.xml");
		dbUnitProvider.execute(DatabaseOperation.INSERT, "Pedido.xml");
	}
	
	@Test
	public void testarIdCliente() {
		assertEquals("1", serv.find(1).getCliente().getId());
	}
	
	@Test
	public void testarFormaPgtoNull() {
		assertNull(serv.find(2).getPagamento());
	}
	
	@Test
	public void testarDataPedidoPrennchida() {
		assertNotNull(serv.find(1).getDataPedido());
	}
	
	@Before
	public void excluirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Pedido.xml");
	}


}
