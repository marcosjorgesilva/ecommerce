package com.marcosjorge.projetojweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosjorge.projetojweb.domain.Cidade;

@Repository
public interface RepoCidade extends JpaRepository<Cidade, Integer>{
	
}