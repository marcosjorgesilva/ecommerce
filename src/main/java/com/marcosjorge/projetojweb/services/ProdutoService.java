package com.marcosjorge.projetojweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marcosjorge.projetojweb.domain.Categoria;
import com.marcosjorge.projetojweb.domain.Produto;
import com.marcosjorge.projetojweb.repositories.RepoCategoria;
import com.marcosjorge.projetojweb.repositories.RepoProduto;
import com.marcosjorge.projetojweb.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private RepoProduto repo;
	
	@Autowired
	private RepoCategoria repoCat;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids,Integer page,Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		List<Categoria> categorias = repoCat.findAllById(ids);
		return repo.findDistincByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
	
}
