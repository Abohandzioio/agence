package com.vehicule.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vehicule.model.Reservation;
import com.vehicule.services.ReservationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping( "/reservation" )
public class ReservationController {
	@Autowired
    ReservationService   reservationService;
	@GetMapping( "/admin" )
	 public String index( Model model ) {
        model.addAttribute( "reservations", reservationService.getAllReservations() );
       
        return "reservation/index";
}
	@GetMapping( "/new/admin" )
    public String newReservation( Model model ) {
        model.addAttribute( "reservation", new Reservation() );

        return "reservation/new";
}
	@PostMapping
    public String create( @Valid Reservation reservation, BindingResult result, RedirectAttributes ra ) {

        if ( result.hasErrors() ) {
            return "reservation/new";
        }

        if ( reservation.getId() != null ) {
            reservationService.updateReservation( reservation.getId(), reservation );
            ra.addFlashAttribute( "success", "La reservation est modifiée avec succès" );
        } else {
            reservationService.createReservation(reservation);
            ra.addFlashAttribute( "success", "La reservation est ajoutée avec succès" );
        }

        return "redirect:/reservation/admin";
    }
	
	@GetMapping( "/show/{id}" )
    public String show( Model model, @PathVariable int id, RedirectAttributes ra ) {
        Optional<Reservation> reservation = reservationService.getReservationById( id );

        if ( reservation.isPresent() ) {
            model.addAttribute( "reservation", reservation.get() );

            return "reservation/show";
        }

        ra.addFlashAttribute( "warning", "La reservation demandée n'exixte pas!" );

        return "redirect:/reservation/admin";
    }
	
	@GetMapping( "/update/{id}" )
    public String update( Model model, @PathVariable int id, RedirectAttributes ra ) {

        Optional<Reservation> reservation = reservationService.getReservationById( id );

        if ( reservation.isPresent() ) {
            model.addAttribute( "reservation", reservation.get() );
            return "reservation/new";
        }

        return "redirect:/reservation/admin";
    }

    @GetMapping( "/delete/{id}" )
    public String delete( @PathVariable int id, RedirectAttributes ra ) {

    	if ( reservationService.getReservationById( id ) == null ) {
            ra.addFlashAttribute( "warning", "Cette reservation n'existe pas ! " );
            return "redirect:/reservation";
        }

        reservationService.deleteReservation( id );
        ra.addFlashAttribute( "success", "Rservation supprimé avec succès ! " );

        return "redirect:/reservation/admin";
    }

}