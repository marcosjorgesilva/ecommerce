package com.marcosjorge.projetojweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosjorge.projetojweb.domain.Cliente;

@Repository
public interface RepoCliente extends JpaRepository<Cliente, Integer>{
	
}