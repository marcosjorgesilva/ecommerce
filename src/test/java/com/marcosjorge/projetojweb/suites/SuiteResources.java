package com.marcosjorge.projetojweb.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.marcosjorge.projetojweb.resources.CategoriaResourceTest;
import com.marcosjorge.projetojweb.resources.ClienteResourceTest;
import com.marcosjorge.projetojweb.resources.PedidoResourceTest;

@RunWith(Suite.class)
@SuiteClasses({
	CategoriaResourceTest.class,
	ClienteResourceTest.class,
	PedidoResourceTest.class
})
public class SuiteResources {
	//Teste de Recursos
}
