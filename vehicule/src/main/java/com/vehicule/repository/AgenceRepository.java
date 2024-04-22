package com.vehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicule.model.Agence;

public interface AgenceRepository  extends JpaRepository<Agence, Integer> {
	
}



