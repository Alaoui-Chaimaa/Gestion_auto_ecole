package com.sid.controllers;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sid.entities.Candidat;
import com.sid.entities.Vehicule;
import com.sid.services.CandidatService;
import com.sid.services.PDFGenerators;

@Controller
@Secured(value= {"ROLE_SECRETAIRE"})
public class CandidatController {

	@Autowired
	private CandidatService serv;
	 @RequestMapping("/Acceuil_Secretaire")
	  public String viewHomePage(Model model) {
	      List<Candidat> Candidats =serv.listCandidats();
	      model.addAttribute("Candidats", Candidats);
	      return "candidats";
	  }
	 @RequestMapping("/candidats")
	  public String viewHomePage1(Model model) {
	      List<Candidat> Candidats =serv.listCandidats();
	      model.addAttribute("Candidats", Candidats);
	      return "candidats";
	  }
	 @RequestMapping("/factures")
	  public String viewHomePage2(Model model) {
	      List<Candidat> candidats =serv.listCandidats();
	      model.addAttribute("candidats", candidats);
	      return "factures";
	  }
	 @RequestMapping("/ajouter_candidat")
	  public String showNewCandidatPage(Model model) {
	      Candidat candidat = new Candidat();
	      model.addAttribute("candidat", candidat);
	       
	      return "AjouterCandidat";
	  }

	@RequestMapping(value = "/enregistrer_candidat", method = RequestMethod.POST) 
	public String saveCandidat(@ModelAttribute("candidat") Candidat candidat,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		          serv.save(candidat,multipartFile);		
		          return "redirect:/candidats";
		          }
	
	 @RequestMapping(value = "/modifier_candidat", method = RequestMethod.POST)
	 public String saveVehicule(@ModelAttribute("candidat") Candidat candidat) {
		
	     serv.saveCandidat(candidat);
	      
	     return "redirect:/candidats";
		
	 }
	 @RequestMapping("/edit_candidat/{id}")
	 public ModelAndView showEditCandidatPage(@PathVariable(name ="id") int id)  {
	     ModelAndView mav = new ModelAndView("edit_candidat");
	     Candidat candidat =  serv.get(id);
	     mav.addObject("candidat", candidat);
	      
	     return mav;
	 }
	 @RequestMapping(value="/modifier_facture", method = RequestMethod.POST)
	 public String showEditFacturePage(@ModelAttribute("candidat") Candidat candidat)  {
		 serv.saveCandidat(candidat);
	      
	     return "redirect:/factures";
	 }
	 @RequestMapping("/facture_candidat/{id}")
	 public ModelAndView showFactureCandidatPage(@PathVariable(name ="id") int id)  {
	     ModelAndView mav = new ModelAndView("facture_candidat");
	     Candidat candidat =  serv.get(id);
	     mav.addObject("candidat", candidat);
	      
	     return mav;
	 }
	 @RequestMapping("/delete_candidat/{id}")
	 public String deleteProduct(@PathVariable(name = "id") int id) {
		 serv.delete(id);
	     return "redirect:/candidats";       
	 }
	 @RequestMapping("/afficher_candidat/{id}")
	 public ModelAndView afficher(@PathVariable(name = "id") int id) {
		 ModelAndView mav = new ModelAndView("afficher_candidat");
	     Candidat candidat =serv.get(id);
        mav.addObject("candidat", candidat);
        return mav;
	            
	 }
	 @GetMapping(value ="/afficherCandidats", produces = MediaType.APPLICATION_PDF_VALUE)
			public ResponseEntity<InputStreamResource> candidsReport() throws IOException {
		       List<Candidat>candidats =serv.listCandidats();
			   ByteArrayInputStream bis = PDFGenerators.customersPDFReport(candidats);

			  HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=candidat.pdf");

			return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));


			    }


}
