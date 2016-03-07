package com.batuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.Prestador;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

	public Prestador findByUserId(Long userId);
}
