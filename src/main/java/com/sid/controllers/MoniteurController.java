package com.sid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sid.entities.Moniteur;
import com.sid.services.MoniteurService;



@Controller
@Secured(value= {"ROLE_RESPONSABLE"})
public class MoniteurController {
	 @Autowired
	    private MoniteurService service;
	     
    /*@RequestMapping("/moniteurs")
	 public String viewHomePage(Model model) {
	     List<Moniteur> listMoniteurs= service.listAll();
	     model.addAttribute("listMoniteurs", listMoniteurs);
	      
	     return "moniteurs";
	 }*/
	 @RequestMapping("/moniteurs")
		public String viewHomePage(Model model, @Param("keyword") String keyword) {
			List<Moniteur> listMoniteurs = service.listAll(keyword);
			model.addAttribute("listMoniteurs", listMoniteurs);
			model.addAttribute("keyword", keyword);
			
			return "moniteurs";
		}
		
	
	 @RequestMapping("/ajouter_moniteur")
	 public String showNewMoniteurPage(Model model) {
	    Moniteur moniteur = new Moniteur();
	     model.addAttribute("moniteur", moniteur);
	      
	     return "ajouter_moniteur";
	 }
	 @RequestMapping(value = "/enregistrer_moniteur", method = RequestMethod.GET)
	 public String saveMoniteur(@ModelAttribute("moniteur") Moniteur moniteur) {
		
	     service.save(moniteur);
	      
	     return "redirect:/moniteurs";
		
	 }
	 @RequestMapping("/edit_moniteur/{id}")
	 public ModelAndView showEditMoniteurPage(@PathVariable(name = "id") long id) {
	     ModelAndView mav = new ModelAndView("modifier_moniteur");
	     Moniteur moniteur = service.get(id);
	     mav.addObject("moniteur", moniteur);
	      
	     return mav;
	 }
	 @RequestMapping("/delete_moniteur/{id}")
	 public String deleteMoniteur(@PathVariable(name = "id") long id) {
	     service.delete(id);
	     return "redirect:/moniteurs";       
	 }
}
