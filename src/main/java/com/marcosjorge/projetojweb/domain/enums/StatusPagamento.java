package com.marcosjorge.projetojweb.domain.enums;

public enum StatusPagamento {
	
	QUITADO(1,"Pedido Quitado"),
	PENDENTE(2,"Pedido Pendente"),
	CANCELADO(3,"Pedido Cancelado");

	private int cod;
	private String descricao;
	
	private StatusPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(StatusPagamento x:StatusPagamento.values()) {
			if (cod.equals(x.getCod())){
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: "+cod+"!");		
	}
}
