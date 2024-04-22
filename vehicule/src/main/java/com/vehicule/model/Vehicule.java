package com.vehicule.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String categorie;

    @DecimalMin(value = "45.0", message = "Le prix journalier doit être d'au moins 45.0 €")
    private double prixJournalier;
    
    @Column( length = 30 )
    private String         couleur;
    
    @Column( length = 30 )
    private int         poids;
    
    
    @Min(value = 2, message = "Le nombre de portes doit être au moins 2")
    @Max(value = 4, message = "Le nombre de portes ne peut pas dépasser 4")
    private int nombrePortes;
    
    @Column( length = 20 )
    private String         cylindre;
    
    @Column( length = 30 )
    private int         longueur;
    
    @OneToMany(mappedBy= "vehicule")
    private List<Reservation>reservation;
    
    @OneToMany(mappedBy= "vehicule")
    private List<Commentaire>commentaire;
    
    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence agence;

	
	}
    
    

   



