package com.marcosjorge.projetojweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosjorge.projetojweb.domain.Categoria;

@Repository
public interface RepoCategoria extends JpaRepository<Categoria, Integer>{
	
}