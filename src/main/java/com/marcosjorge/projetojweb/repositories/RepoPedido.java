package com.marcosjorge.projetojweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosjorge.projetojweb.domain.Pedido;

@Repository
public interface RepoPedido extends JpaRepository<Pedido, Integer>{
	
}