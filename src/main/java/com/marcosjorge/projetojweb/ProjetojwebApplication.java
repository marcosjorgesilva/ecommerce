package com.marcosjorge.projetojweb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcosjorge.projetojweb.domain.Categoria;
import com.marcosjorge.projetojweb.domain.Cidade;
import com.marcosjorge.projetojweb.domain.Estado;
import com.marcosjorge.projetojweb.domain.Produto;
import com.marcosjorge.projetojweb.repositories.RepoCategoria;
import com.marcosjorge.projetojweb.repositories.RepoCidade;
import com.marcosjorge.projetojweb.repositories.RepoEstado;
import com.marcosjorge.projetojweb.repositories.RepoProduto;

@SpringBootApplication
public class ProjetojwebApplication implements CommandLineRunner {
	@Autowired
	private RepoCategoria repoCateg;
	@Autowired
	private RepoProduto repoProd;
	@Autowired
	private RepoEstado repoEst;
	@Autowired
	private RepoCidade repoCid;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetojwebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Feminino");
		Categoria cat2 = new Categoria(null,"Masculino");
		
		Produto prod1 = new Produto(null, "Camisa", 40.00);
		Produto prod2 = new Produto(null, "Blusa", 49.99);
		Produto prod3 = new Produto(null, "Jaqueta", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		Estado est1 = new Estado(null,"Sao Paulo",null);
		Estado est2 = new Estado(null,"Pernambuco",null);
		Estado est3 = new Estado(null,"Minas Gerais",null);
		
		Cidade c1 = new Cidade(null,"Sao Paulo",est1);
		Cidade c2 = new Cidade(null,"Uberlandia",est2);
		Cidade c3 = new Cidade(null,"Recife",est3);
		Cidade c4 = new Cidade(null,"Jaboatao Dos Guararapes",est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));	
		est2.getCidades().addAll(Arrays.asList(c3,c4));
		est3.getCidades().addAll(Arrays.asList(c2));
		
		
		repoCateg.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		repoEst.saveAll(Arrays.asList(est1,est2,est3));
		repoCid.saveAll(Arrays.asList(c1,c2,c3,c4));
		
	}

}
