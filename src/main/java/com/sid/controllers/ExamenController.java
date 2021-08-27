package com.sid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sid.entities.Depense;
import com.sid.entities.Examen;
import com.sid.entities.Moniteur;
import com.sid.services.ExamenService;

@Controller
@Secured(value= {"ROLE_RESPONSABLE"})
public class ExamenController {

	@Autowired
	private ExamenService exas;
	
     @RequestMapping("/examens")
	 public String viewHomePage(Model model) {
	     List<Examen> listExamens= exas.listAll();
	     model.addAttribute("listExamens", listExamens);
	      
	     return "examens";
	 }
    @RequestMapping("/ajouter_examen")
	 public String showNewExamenPage(Model model) {
	     Examen examen = new Examen();
	     model.addAttribute("examen",examen);
	      
	     return "ajouter_examen";
	 }
	 @RequestMapping(value = "/enregistrer_examen", method = RequestMethod.POST)
	 public String saveExamen(@ModelAttribute("examen") Examen examen) {
		
	    exas.save(examen);
	      
	     return "redirect:/examens";
		
	 }
	 @RequestMapping("/edit_examen/{id}")
	 public ModelAndView showEditExamenPage(@PathVariable(name = "id") long id) {
	     ModelAndView mav = new ModelAndView("modifier_examen");
	    Examen examen = exas.get(id);
	     mav.addObject("examen", examen);
	      
	     return mav;
	 }
	 @RequestMapping("/delete_examen/{id}")
	 public String deleteExamen(@PathVariable(name = "id") long id) {
	     exas.delete(id);
	     return "redirect:/examens";       
	 }
}
