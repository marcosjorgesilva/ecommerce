package com.marcosjorge.projetojweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosjorge.projetojweb.domain.Categoria;
import com.marcosjorge.projetojweb.repositories.RepoCategoria;
import com.marcosjorge.projetojweb.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private RepoCategoria repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
