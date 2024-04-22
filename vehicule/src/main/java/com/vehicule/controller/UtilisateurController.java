package com.vehicule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vehicule.model.Utilisateur;
import com.vehicule.repository.UtilisateurRepository;
import com.vehicule.services.UtilisateurService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
@RequestMapping( "/utilisateur" )
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    UtilisateurService utilisateurService;
    @GetMapping( "/logon" )
    public String logon( Model model ) {
        model.addAttribute( "utilisateur", new Utilisateur() );

        return "user/add";
    }

    @GetMapping( "/login" )
    public String login(@Param("login") String login, @Param("mdp") String mdp, HttpSession httpSession) {
    	Utilisateur utilisateur = utilisateurRepository.findByLoginAndMdp(login,mdp);
    	if(utilisateur != null  ) {
    		httpSession.setAttribute("utilisateur", utilisateur);
    	}
        return "user/login";
    }

    @GetMapping( "/logout" )
    public String logout( HttpSession session ) {
        session.invalidate();

        return "redirect:/";
    }
    
    @PostMapping
    public String add(@Valid Utilisateur utilisateur, BindingResult result, RedirectAttributes attributes, Model model) {
    	System.out.println(utilisateur);
    	System.out.println(result);
    	if(result.hasErrors()) {
    		attributes.addAttribute("erreur", "Veillez remplir tout les champs");
    		model.addAttribute("utilisateur", new Utilisateur());
    	}
    	
    	
    	utilisateurService.addUser(utilisateur);
		
		return "redirect:/";
    }
}
