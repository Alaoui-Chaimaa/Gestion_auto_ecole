package com.sid.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sid.entities.Vehicule;
import com.sid.services.VehiculeService;

import java.text.SimpleDateFormat;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
@Controller
@Secured(value= {"ROLE_RESPONSABLE"})
public class VehiculeController {
	 @Autowired
	    private VehiculeService service;
	     
	 @RequestMapping("/")
	 public String viewHomePage(Model model) {
	     List<Vehicule> listVehicules= service.listAll();
	     model.addAttribute("listVehicules", listVehicules);
	      
	     return "vehicule";
	 }
	 @RequestMapping("/ajouter_vehicule")
	 public String showNewVehiculePage(Model model) {
	     Vehicule vehicule = new Vehicule();
	     model.addAttribute("vehicule", vehicule);
	      
	     return "ajouter_vehicule";
	 }
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String saveVehicule(@ModelAttribute("vehicule") Vehicule vehicule) {
		
	     service.save(vehicule);
	      
	     return "redirect:/";
		
	 }
	 @RequestMapping("/edit/{matricule}")
	 public ModelAndView showEditVehiculePage(@PathVariable(name = "matricule") String matricule) {
	     ModelAndView mav = new ModelAndView("modifier_vehicule");
	     Vehicule vehicule = service.get(matricule);
	     mav.addObject("vehicule", vehicule);
	      
	     return mav;
	 }
	 @RequestMapping("/delete/{matricule}")
	 public String deleteVehicule(@PathVariable(name = "matricule") String matricule) {
	     service.delete(matricule);
	     return "redirect:/";       
	 }
}
