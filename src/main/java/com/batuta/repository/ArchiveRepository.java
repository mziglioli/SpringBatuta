package com.batuta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.batuta.model.Archive;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {

	public Archive findByUsername(String username);
	
	@Query(value="Select distinct peer from Archive where username = ?1")
	public List<String> findAllPeerBySender(String sender);
	
		
}
