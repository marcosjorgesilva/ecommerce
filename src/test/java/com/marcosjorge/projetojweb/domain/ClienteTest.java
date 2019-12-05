package com.marcosjorge.projetojweb.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marcosjorge.projetojweb.services.ClienteService;

public class ClienteTest {
	
	ClienteService serv = new ClienteService();
	
	@Test
	public void testEmail() {
		assertTrue(serv.find(1).getEmail() == "marcos@gmail.com");
	}
	
	@Test
	public void testCpfCnpj() {
		assertFalse(serv.find(1).getCpfOuCnpj() == "22548535651");
	}
	
	@Test
	public void testTipoCliente() {
		assertEquals(serv.find(2).getTipo(), "1");
	}
	
}
