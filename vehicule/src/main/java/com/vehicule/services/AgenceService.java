package com.vehicule.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.model.Agence;
import com.vehicule.repository.AgenceRepository;
@Service
public class AgenceService {
	@Autowired
	AgenceRepository agenceRepository;
	
	 // Méthode pour récupérer tous les agences
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }
    
    // Méthode pour récupérer une agence par son ID
    public Optional<Agence> getAgenceById(Integer agenceId) {
        return agenceRepository.findById(agenceId);
    }
	
    // Méthode pour ajouter une agence
    public Agence addAgencer(Agence agence) {
        return agenceRepository.save(agence);
    }

    // Méthode pour mettre à jour une agence
    public Agence updateAgence(Integer agenceId, Agence agenceDetails) {
        Optional<Agence> agenceOptional = agenceRepository.findById(agenceId);
        if (agenceOptional.isPresent()) {
            Agence agence = agenceOptional.get();
            agence.setNom(agenceDetails.getNom());
            agence.setEmail(agenceDetails.getEmail());
            agence.setTel(agenceDetails.getTel());
            agence.setRue(agenceDetails.getRue());
            agence.setCp(agenceDetails.getCp());
            agence.setVille(agenceDetails.getVille());
            return agenceRepository.save(agence);
        } else {
            return null; // Agence non trouvé
        }
    }

    // Méthode pour supprimer une agence
    public void deleteAgence(Integer agenceId) {
        agenceRepository.deleteById(agenceId);
    }
    
    public Agence createAgence( Agence agence ) {
        return agenceRepository.save( agence );
    }
}
