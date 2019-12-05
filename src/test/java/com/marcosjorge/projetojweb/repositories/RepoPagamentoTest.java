package com.marcosjorge.projetojweb.repositories;

import static org.junit.Assert.*;

import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

import dbUnit.DbUnitProvider;

public class RepoPagamentoTest {

	DbUnitProvider dbUnitProvider = new DbUnitProvider();
	
	@Before
	public void inserirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Pagamento.xml");
		dbUnitProvider.execute(DatabaseOperation.INSERT, "Pagamento.xml");
	}
	
	@Test
	public void verificaDadosNaBase() {
		fail("Not yet implemented");
	}
	
	@Before
	public void excluirDadosCidade() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Pagamento.xml");
	}


}
