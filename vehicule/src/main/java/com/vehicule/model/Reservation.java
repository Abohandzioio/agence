package com.vehicule.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur user;

    @ManyToOne
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;
    
    @Column( length = 8 )
    private Date dateDebut;
    
    @Column( length = 8 )
    private Date dateFin;
    
    
    private double coutTotal;

    
}

