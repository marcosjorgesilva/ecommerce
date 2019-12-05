package com.marcosjorge.projetojweb.repositories;

import static org.junit.Assert.*;

import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

import dbUnit.DbUnitProvider;

public class RepoProdutoTest {

	DbUnitProvider dbUnitProvider = new DbUnitProvider();
	
	@Before
	public void inserirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Produto.xml");
		dbUnitProvider.execute(DatabaseOperation.INSERT, "Produto.xml");
	}
	
	@Test
	public void verificaDadosNaBase() {
		fail("Not yet implemented");
	}
	
	@Before
	public void excluirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Produto.xml");
	}


}
