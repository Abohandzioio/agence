package com.vehicule.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    
    @Column( length = 30 )
    private String         nom;
    
    @NotBlank
    @Size(min = 2, max = 30, message = "Le prénom doit avoir entre 2 et 30 caractères")
    private String prenom;

    @NotBlank
    @Size(min = 6, max = 8, message = "Le login doit avoir entre 6 et 8 caractères")
    @Pattern(regexp = "^[a-z]+$", message = "Le login doit contenir uniquement des lettres minuscules")
    private String login;

    @Column( length = 30 )
    private String         email;
    
    @Column( length = 20 )
    private String         mdp;
    
    @Column( length = 8 )
    private String         type_profil;
    
    @Column( length = 20 )
    private String         adresse;
    
    @Column( length = 5 )
    private int         cp;
    
    @Column( length = 10 )
    private String         ville;
    
    @Column( length = 8 )
    private int         tel;
    
    @OneToMany(mappedBy= "user")
    private List<Reservation>reservation;
    
    @OneToMany(mappedBy= "user")
    private List<Commentaire>commentaire;

	

	

    
}

