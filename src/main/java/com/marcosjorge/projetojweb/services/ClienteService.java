package com.marcosjorge.projetojweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosjorge.projetojweb.domain.Cliente;
import com.marcosjorge.projetojweb.repositories.RepoCliente;
import com.marcosjorge.projetojweb.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private RepoCliente repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
}
