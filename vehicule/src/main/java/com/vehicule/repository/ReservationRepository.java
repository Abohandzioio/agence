package com.vehicule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.model.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
