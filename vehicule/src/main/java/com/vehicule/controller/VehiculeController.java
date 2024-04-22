package com.vehicule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vehicule.model.Vehicule;
import com.vehicule.services.AgenceService;
import com.vehicule.services.VehiculeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping( "/vehicule" )
public class VehiculeController {
	@Autowired
    VehiculeService   vehiculeService;
	
	@Autowired
    AgenceService   agenceService;
	@GetMapping( "/admin" )
    public String index( Model model ) {
        model.addAttribute( "vehicule", new Vehicule() );
       
        return "vehicule/index";
    }
	
    @GetMapping( "/new/admin" )
    public String create( Model model ) {
        model.addAttribute( "vehicule", new Vehicule() );
        //model.addAttribute( "agences", agenceService.getAllAgences() );

        return "vehicule/new";
    }

    @PostMapping
    public String insert( @Valid Vehicule vehicule, BindingResult result, RedirectAttributes ra, Model model ) {

        if ( result.hasErrors() ) {
           vehiculeService.addVehiculer(vehicule);
        }
        
        vehiculeService.createVehicule( vehicule );
        ra.addFlashAttribute( "success", "Vehicule créé avec succès ! " );

        return "redirect:/vehicule/admin";

}
}
