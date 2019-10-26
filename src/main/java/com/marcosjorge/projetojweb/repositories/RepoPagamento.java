package com.marcosjorge.projetojweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcosjorge.projetojweb.domain.Pagamento;

@Repository
public interface RepoPagamento extends JpaRepository<Pagamento, Integer>{
	
}