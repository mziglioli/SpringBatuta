package com.batuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.Erro;

public interface ErroRepository extends JpaRepository<Erro, Long> {

	public Erro findByAssunto(String assunto);
	
}
