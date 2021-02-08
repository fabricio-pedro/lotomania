package com.lotomania.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lotomania.api.model.Apostador;

public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
 
	public Optional<Apostador> findByEmail(String email);
	
}
