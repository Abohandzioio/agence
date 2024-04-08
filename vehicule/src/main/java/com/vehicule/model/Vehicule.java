package com.vehicule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String type;

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
    private String         longueur;

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", type=" + type + ", prixJournalier=" + prixJournalier + ", couleur=" + couleur
				+ ", poids=" + poids + ", nombrePortes=" + nombrePortes + ", cylindre=" + cylindre + ", longueur="
				+ longueur + "]";
	}
    
    

   
}

