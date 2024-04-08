package com.vehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.model.Commentaire;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

}
