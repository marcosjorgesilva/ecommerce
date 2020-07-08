package com.marcosjorge.projetojweb;

import java.text.SimpleDateFormat;
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
import com.marcosjorge.projetojweb.domain.ItemPedido;
import com.marcosjorge.projetojweb.domain.Pagamento;
import com.marcosjorge.projetojweb.domain.PagamentoBoleto;
import com.marcosjorge.projetojweb.domain.PagamentoCartao;
import com.marcosjorge.projetojweb.domain.Pedido;
import com.marcosjorge.projetojweb.domain.Produto;
import com.marcosjorge.projetojweb.domain.enums.StatusPagamento;
import com.marcosjorge.projetojweb.domain.enums.TipoCliente;
import com.marcosjorge.projetojweb.repositories.RepoCategoria;
import com.marcosjorge.projetojweb.repositories.RepoCidade;
import com.marcosjorge.projetojweb.repositories.RepoCliente;
import com.marcosjorge.projetojweb.repositories.RepoEndereco;
import com.marcosjorge.projetojweb.repositories.RepoEstado;
import com.marcosjorge.projetojweb.repositories.RepoItemPedido;
import com.marcosjorge.projetojweb.repositories.RepoPagamento;
import com.marcosjorge.projetojweb.repositories.RepoPedido;
import com.marcosjorge.projetojweb.repositories.RepoProduto;

@SpringBootApplication
public class ProjetojwebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetojwebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
