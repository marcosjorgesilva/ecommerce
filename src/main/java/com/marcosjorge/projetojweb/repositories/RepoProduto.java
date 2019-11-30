package com.marcosjorge.projetojweb.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marcosjorge.projetojweb.domain.Categoria;
import com.marcosjorge.projetojweb.domain.Produto;

@Repository
public interface RepoProduto extends JpaRepository<Produto, Integer>{
	
	@Transactional(readOnly=true)
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page <Produto> findDistincByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias,Pageable pageRequest);
}