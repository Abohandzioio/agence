package com.vehicule.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.model.Reservation;
import com.vehicule.repository.ReservationRepository;
@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	
	 // Méthode pour récupérer tous les reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    
    // Méthode pour récupérer une reservation par son ID
    public Optional<Reservation> getReservationById(Integer reservationId) {
        return reservationRepository.findById(reservationId);
    }
	
    // Méthode pour ajouter une reservation
    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Méthode pour mettre à jour une reservation
    public Reservation updateReservation(Integer reservationId, Reservation reservationDetails) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        if (reservationOptional.isPresent()) {
           Reservation reservation = reservationOptional.get();
            reservation.setDateDebut(reservationDetails.getDateDebut());
            reservation.setDateFin(reservationDetails.getDateFin());
            
            return reservationRepository.save(reservation);
        } else {
            return null; // reservation non trouvé
        }
    }

    // Méthode pour supprimer une reservation
    public void deleteReservation(Integer reservationId) {
        reservationRepository.deleteById(reservationId);
    }
    
    public Reservation createReservation( Reservation reservation ) {
        return reservationRepository.save( reservation );
    }
}
