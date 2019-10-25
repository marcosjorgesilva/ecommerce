package com.marcosjorge.projetojweb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcosjorge.projetojweb.domain.Categoria;
import com.marcosjorge.projetojweb.domain.Cidade;
import com.marcosjorge.projetojweb.domain.Cliente;
import com.marcosjorge.projetojweb.domain.Endereco;
import com.marcosjorge.projetojweb.domain.Estado;
import com.marcosjorge.projetojweb.domain.Produto;
import com.marcosjorge.projetojweb.domain.enums.TipoCliente;
import com.marcosjorge.projetojweb.repositories.RepoCategoria;
import com.marcosjorge.projetojweb.repositories.RepoCidade;
import com.marcosjorge.projetojweb.repositories.RepoCliente;
import com.marcosjorge.projetojweb.repositories.RepoEndereco;
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
	@Autowired
	private RepoCliente repoCli;
	@Autowired
	private RepoEndereco repoEnd;
	
	
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
		
		Estado est1 = new Estado(null,"Sao Paulo");
		Estado est2 = new Estado(null,"Pernambuco");
		Estado est3 = new Estado(null,"Minas Gerais");
		
		Cidade c1 = new Cidade(null,"Sao Paulo",est1);
		Cidade c2 = new Cidade(null,"Uberlandia",est2);
		Cidade c3 = new Cidade(null,"Recife",est3);
		Cidade c4 = new Cidade(null,"Jaboatao Dos Guararapes",est3);
		
		Cliente cli1 =  new Cliente(null,"Marcos Jorge","marcos@gmail.com","22548535651",TipoCliente.PESSOAFISICA);
		Cliente cli2 =  new Cliente(null,"Jacileide David","jacileide@gmail.com","88548565425",TipoCliente.PESSOAFISICA);
		Cliente cli3 =  new Cliente(null,"Maria Cecilia","maria@gmail.com","11116895145",TipoCliente.PESSOAFISICA);
		
		Endereco e1 = new Endereco(null,"Rua Nova Roma","340","Apto 104","Conjunto Laranjeiras","54450555",cli1,c1);
		Endereco e2 = new Endereco(null,"Rua Esperanca","12","Casa 01","Prox. ao Mercado zona sul","54450302",cli1,c2);
			
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		repoCateg.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		est1.getCidades().addAll(Arrays.asList(c1));	
		est2.getCidades().addAll(Arrays.asList(c3,c4));
		est3.getCidades().addAll(Arrays.asList(c2));
		
		repoEst.saveAll(Arrays.asList(est1,est2,est3));
		repoCid.saveAll(Arrays.asList(c1,c2,c3));
		
		repoEst.saveAll(Arrays.asList(est1,est2,est3));
		repoCid.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		cli1.getTelefones().addAll(Arrays.asList("996486478","996482131"));
		cli2.getTelefones().addAll(Arrays.asList("996511546","996482131"));
		cli3.getTelefones().addAll(Arrays.asList("999911656","996482131"));
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		repoCli.saveAll(Arrays.asList(cli1,cli2,cli3));
		repoEnd.saveAll(Arrays.asList(e1,e2));
	}

}
