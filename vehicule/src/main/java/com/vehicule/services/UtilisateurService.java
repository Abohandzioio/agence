package com.vehicule.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.model.Utilisateur;
import com.vehicule.repository.UtilisateurRepository;
@Service
public class UtilisateurService {
	  @Autowired
	    private UtilisateurRepository utilisateurRepository;

	    // Méthode pour récupérer tous les utilisateurs
	    public List<Utilisateur> getAllUsers() {
	        return utilisateurRepository.findAll();
	    }

	    // Méthode pour récupérer un utilisateur par son ID
	    public Optional<Utilisateur> getUserById(Integer utilisateurId) {
	        return utilisateurRepository.findById(utilisateurId);
	    }

	    // Méthode pour ajouter un utilisateur
	    public Utilisateur addUser(Utilisateur utilisateur) {
	        return utilisateurRepository.save(utilisateur);
	    }

	    // Méthode pour mettre à jour un utilisateur
	    public Utilisateur updateUser(Integer utilisateurId, Utilisateur utilisateurDetails) {
	        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(utilisateurId);
	        if (utilisateurOptional.isPresent()) {
	            Utilisateur utilisateur = utilisateurOptional.get();
	            utilisateur.setNom(utilisateurDetails.getNom());
	            utilisateur.setPrenom(utilisateurDetails.getPrenom());
	            utilisateur.setType_profil(utilisateurDetails.getType_profil());
	            return utilisateurRepository.save(utilisateur);
	        } else {
	            return null; // Utilisateur non trouvé
	        }
	    }

	    // Méthode pour supprimer un utilisateur
	    public void deleteUser(Integer utilisateurId) {
	        utilisateurRepository.deleteById(utilisateurId);
	    }
}
