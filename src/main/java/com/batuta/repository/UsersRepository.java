package com.batuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	
}
