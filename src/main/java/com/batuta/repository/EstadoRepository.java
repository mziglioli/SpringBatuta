package com.batuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	public Estado findByNome(String nome);
	
}
