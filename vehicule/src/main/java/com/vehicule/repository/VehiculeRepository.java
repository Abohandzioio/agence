	package com.vehicule.repository;
	
	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.model.Vehicule;
	
	@Repository
	public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
	
	}
