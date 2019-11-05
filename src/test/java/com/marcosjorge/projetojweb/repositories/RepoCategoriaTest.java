package com.marcosjorge.projetojweb.repositories;

import static org.junit.Assert.*;

import org.dbunit.operation.DatabaseOperation;
import org.junit.*;

import dbUnit.DbUnitProvider;

public class RepoCategoriaTest {

	DbUnitProvider dbUnitProvider = new DbUnitProvider();
	
	@Before
	public void inserirDados() {
		dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "categoria.xml");
		dbUnitProvider.execute(DatabaseOperation.INSERT, "categoria.xml");
	}

	@Test
	public void VerificarCargaPorId() {
		//assertNotNull("Encontrado!",new Object());
	}

	@After 
	public void apagarDados() {
		//dbUnitProvider.execute(DatabaseOperation.DELETE_ALL, "Categoria.xml");
	}
}


