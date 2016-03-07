package com.batuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	public Cidade findByNome(String login);
	
}
