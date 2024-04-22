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

import com.vehicule.model.Agence;
import com.vehicule.services.AgenceService;

import jakarta.validation.Valid;

@Controller
@RequestMapping( "/agence" )
public class AgenceController {
	@Autowired
    AgenceService   agenceService;
	@GetMapping( "/admin" )
    public String index( Model model ) {
        model.addAttribute( "agences", agenceService.getAllAgences() );
       
        return "agence/index";
    }

	@GetMapping( "/new" )
    public String newAgence( Model model ) {
        model.addAttribute( "agence", new Agence() );

        return "agence/new";

}
	@PostMapping
    public String create( @Valid Agence agence, BindingResult result, RedirectAttributes ra ) {

        if ( result.hasErrors() ) {
            return "agence/new";
        }

        if ( agence.getId_agence() != null ) {
            agenceService.updateAgence( agence.getId_agence(), agence );
            ra.addFlashAttribute( "success", "La agence est modifiée avec succès" );
        } else {
            agenceService.createAgence(agence);
            ra.addFlashAttribute( "success", "La agence est ajoutée avec succès" );
        }

        return "redirect:/agence/admin";
    }
	
	@GetMapping( "/show/{id}" )
    public String show( Model model, @PathVariable int id, RedirectAttributes ra ) {
        Optional<Agence> agence = agenceService.getAgenceById( id );

        if ( agence.isPresent() ) {
            model.addAttribute( "agence", agence.get() );

            return "agence/show";
        }

        ra.addFlashAttribute( "warning", "L'agence demandée n'exixte pas!" );

        return "redirect:/agence/admin";
    }
	
	@GetMapping( "/update/{id_agence}" )
    public String update( Model model, @PathVariable int id_agence, RedirectAttributes ra ) {

        Optional<Agence> agence = agenceService.getAgenceById( id_agence );

        if ( agence.isPresent() ) {
            model.addAttribute( "agence", agence.get() );
            return "agence/new";
        }

        return "redirect:/agence/admin";
    }

    @GetMapping( "/delete/{id_agence}" )
    public String delete( @PathVariable int id_agence, RedirectAttributes ra ) {

    	if ( agenceService.getAgenceById( id_agence ) == null ) {
            ra.addFlashAttribute( "warning", "Cet agence n'existe pas ! " );
            return "redirect:/agence";
        }

        agenceService.deleteAgence( id_agence );
        ra.addFlashAttribute( "success", "Agence supprimé avec succès ! " );

        return "redirect:/agence/admin";
    }



        

}

