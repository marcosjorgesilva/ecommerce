package com.marcosjorge.projetojweb.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosjorge.projetojweb.domain.ItemPedido;
import com.marcosjorge.projetojweb.domain.PagamentoBoleto;
import com.marcosjorge.projetojweb.domain.Pedido;
import com.marcosjorge.projetojweb.domain.enums.StatusPagamento;
import com.marcosjorge.projetojweb.repositories.RepoItemPedido;
import com.marcosjorge.projetojweb.repositories.RepoPagamento;
import com.marcosjorge.projetojweb.repositories.RepoPedido;
import com.marcosjorge.projetojweb.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private RepoPedido repo;
	
	@Autowired
	private BoletoService boletoService;

	@Autowired
	private RepoPagamento repoPag;

	@Autowired
	private RepoItemPedido repoIPed;

	@Autowired
	private ProdutoService produtoService;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setDataPedido(new Date());
		obj.getPagamento().setStatus(StatusPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoBoleto) {
			PagamentoBoleto pagto = (PagamentoBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getDataPedido());
		}
		obj = repo.save(obj);
		repoPag.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		repoIPed.saveAll(obj.getItens());
		return obj;
	}
	
}
