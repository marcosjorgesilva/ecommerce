package com.marcosjorge.projetojweb.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.marcosjorge.projetojweb.services.CategoriaServiceTest;
import com.marcosjorge.projetojweb.services.ClienteServiceTest;
import com.marcosjorge.projetojweb.services.PedidoServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	CategoriaServiceTest.class,
	ClienteServiceTest.class,
	PedidoServiceTest.class
})
public class SuiteServices {
	//Teste de Servicos
}
