	package com.vehicule.repository;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	
	import com.vehicule.model.Utilisateur;
	
		@Repository
		public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
		
	}
