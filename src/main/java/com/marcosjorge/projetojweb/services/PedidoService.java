package com.marcosjorge.projetojweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosjorge.projetojweb.domain.Pedido;
import com.marcosjorge.projetojweb.repositories.RepoPedido;
import com.marcosjorge.projetojweb.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private RepoPedido repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}