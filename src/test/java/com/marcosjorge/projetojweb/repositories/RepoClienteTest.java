package com.marcosjorge.projetojweb.repositories;

import static org.junit.Assert.*;

import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

import com.marcosjorge.projetojweb.services.ClienteService;

import dbUnit.DbUnitProvider;

public class RepoClienteTest {

	DbUnitProvider dbUnitProvider = new DbUnitProvider();
	ClienteService serv = new ClienteService();
	
	@Before
	public void inserirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Cliente.xml");
		dbUnitProvider.execute(DatabaseOperation.INSERT, "Cliente.xml");
	}
	
	@Test
	public void testarCPFouCNPJ() {
		assertTrue(serv.find(1).getCpfOuCnpj() == "95702706080"); 
	}
	
	@Test
	public void testarNome() {
		assertNotNull(serv.find(1).getNome());
	}
	
	@Test
	public void testarTelefoneNotNull() {
		assertNotNull(serv.find(1).getTelefones());
	}
	
	@Before
	public void excluirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Cliente.xml");
	}

}
