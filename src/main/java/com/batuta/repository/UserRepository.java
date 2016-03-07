package com.batuta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String login);
	
}
