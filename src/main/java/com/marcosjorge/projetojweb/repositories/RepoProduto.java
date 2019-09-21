package com.marcosjorge.projetojweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosjorge.projetojweb.domain.Produto;

@Repository
public interface RepoProduto extends JpaRepository<Produto, Integer>{
	
}