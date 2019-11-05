package com.marcosjorge.projetojweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosjorge.projetojweb.domain.ItemPedido;

@Repository
public interface RepoItemPedido extends JpaRepository<ItemPedido, Integer>{
	
}