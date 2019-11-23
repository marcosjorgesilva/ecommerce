package com.marcosjorge.projetojweb.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.marcosjorge.projetojweb.repositories.RepoCategoriaTest;
import com.marcosjorge.projetojweb.repositories.RepoCidadeTest;
import com.marcosjorge.projetojweb.repositories.RepoClienteTest;
import com.marcosjorge.projetojweb.repositories.RepoEnderecoTest;
import com.marcosjorge.projetojweb.repositories.RepoEstadoTest;
import com.marcosjorge.projetojweb.repositories.RepoPagamentoTest;
import com.marcosjorge.projetojweb.repositories.RepoPedidoTest;
import com.marcosjorge.projetojweb.repositories.RepoProdutoTest;

@RunWith(Suite.class)
@SuiteClasses({
	RepoCategoriaTest.class,
	RepoCidadeTest.class,
	RepoClienteTest.class,
	RepoEnderecoTest.class,
	RepoEstadoTest.class,
	RepoPagamentoTest.class,
	RepoPedidoTest.class,
	RepoProdutoTest.class
})
public class SuiteRepositories {
	//Teste de Repositorio
}
