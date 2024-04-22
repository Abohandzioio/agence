package com.vehicule.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.model.Vehicule;
import com.vehicule.repository.VehiculeRepository;
@Service
public class VehiculeService {
	@Autowired
	VehiculeRepository vehiculeRepository;
	
	 // Méthode pour récupérer tous les agences
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }
    
    // Méthode pour récupérer une agence par son ID
    public Optional<Vehicule> getVehiculeById(Integer vehiculeId) {
        return vehiculeRepository.findById(vehiculeId);
    }
	
    // Méthode pour ajouter une agence
    public Vehicule addVehiculer(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // Méthode pour mettre à jour une agence
    public Vehicule updateVehicule(Integer vehiculeId, Vehicule vehiculeDetails) {
        Optional<Vehicule> vehiculeOptional = vehiculeRepository.findById(vehiculeId);
        if (vehiculeOptional.isPresent()) {
            Vehicule vehicule = vehiculeOptional.get();
            vehicule.setCategorie(vehiculeDetails.getCategorie());
            vehicule.setPrixJournalier(vehiculeDetails.getPrixJournalier());
            vehicule.setPoids(vehiculeDetails.getPoids());
           // vehicule.setNombreDePorte(vehiculeDetails.getNombreDePorte());
            vehicule.setCylindre(vehiculeDetails.getCylindre());
            vehicule.setLongueur(vehiculeDetails.getLongueur());
            return vehiculeRepository.save(vehicule);
        } else {
            return null; // Vehicule non trouvé
        }
    }

    // Méthode pour supprimer un Vehicule
    public void deleteVehicule(Integer vehiculeId) {
        vehiculeRepository.deleteById(vehiculeId);
    }
    
    public Vehicule createVehicule( Vehicule vehicule ) {
        return vehiculeRepository.save( vehicule );
    }
}
