package com.sid.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sid.entities.Candidat;

import com.sid.services.CandidatService;
@Controller
public class AcceuilController {

	@Autowired
	private CandidatService serv;
	@RequestMapping("/Acceuil")
	public String Affichage()
	{
		return "page_acceuil";
	}

	@Secured(value= {"ROLE_RESPONSABLE"})
	@RequestMapping("/Acceuil_Admin")
	  public String viewHomePage1(Model model) {
	      List<Candidat> Candidats =serv.listCandidats();
	      model.addAttribute("Candidats", Candidats);
	      return "candidats_admin";
	  }
	
}
