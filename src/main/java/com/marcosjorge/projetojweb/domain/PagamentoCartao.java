package com.marcosjorge.projetojweb.domain;

import javax.persistence.Entity;

import com.marcosjorge.projetojweb.domain.enums.StatusPagamento;

@Entity
public class PagamentoCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelas;
	
	public PagamentoCartao() {
	}

	public PagamentoCartao(Integer id, StatusPagamento status, Pedido pedido, Integer numeroParcelas) {
		super(id, status, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
		
}
