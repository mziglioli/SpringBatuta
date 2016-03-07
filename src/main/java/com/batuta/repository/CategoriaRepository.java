package com.batuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public Categoria findByNome(String nome);
		
}
