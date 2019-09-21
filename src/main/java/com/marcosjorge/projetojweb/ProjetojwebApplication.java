package com.marcosjorge.projetojweb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcosjorge.projetojweb.domain.Categoria;
import com.marcosjorge.projetojweb.domain.Produto;
import com.marcosjorge.projetojweb.repositories.RepoCategoria;
import com.marcosjorge.projetojweb.repositories.RepoProduto;

@SpringBootApplication
public class ProjetojwebApplication implements CommandLineRunner {
	@Autowired
	private RepoCategoria repoCateg;
	@Autowired
	private RepoProduto repoProd;
	
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
		
		repoCateg.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(prod1,prod2,prod3));
	}

}
