package com.sid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sid.entities.Depense;
import com.sid.entities.Moniteur;
import com.sid.entities.Vehicule;
import com.sid.services.DepenseService;

@Controller
@Secured(value= {"ROLE_RESPONSABLE"})
public class DepenseController {

	@Autowired
	private DepenseService service;
	 @RequestMapping("/depenses")
	 public String viewHomePage(Model model) {
	     List<Depense> listDepenses= service.listAll();
	     model.addAttribute("listDepenses", listDepenses);
	      
	     return "depenses";
	 }
	 @RequestMapping("/ajouter_depense")
	 public String showNewMoniteurPage(Model model) {
	    Depense depense = new Depense();
	     model.addAttribute("depense",depense);
	      
	     return "ajouter_depense";
	 }
	 @RequestMapping(value = "/enregistrer_depense", method = RequestMethod.POST)
	 public String saveDepense(@ModelAttribute("depense") Depense depense) {
		
	     service.save(depense);
	      
	     return "redirect:/depenses";
		
	 }
}
