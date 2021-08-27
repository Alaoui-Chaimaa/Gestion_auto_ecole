package com.sid.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="examen")
public class Examen {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	 private String nom;
	 private String cin;
	 private Date date_exam_theorique;
	 private String resultat1;
	 private Date date_exam_pratique;
	 private String resultat2;
	 private String resultat_finale;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Date getDate_exam_theorique() {
		return date_exam_theorique;
	}
	public void setDate_exam_theorique(Date date_exam_theorique) {
		this.date_exam_theorique = date_exam_theorique;
	}
	public String getResultat1() {
		return resultat1;
	}
	public void setResultat1(String resultat1) {
		this.resultat1 = resultat1;
	}
	public Date getDate_exam_pratique() {
		return date_exam_pratique;
	}
	public void setDate_exam_pratique(Date date_exam_pratique) {
		this.date_exam_pratique = date_exam_pratique;
	}
	public String getResultat2() {
		return resultat2;
	}
	public void setResultat2(String resultat2) {
		this.resultat2 = resultat2;
	}
	public String getResultat_finale() {
		return resultat_finale;
	}
	public void setResultat_finale(String resultat_finale) {
		this.resultat_finale = resultat_finale;
	}
	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Examen(String nom, String cin, Date date_exam_theorique, String resultat1, Date date_exam_pratique,
			String resultat2, String resultat_finale) {
		super();
		this.nom = nom;
		this.cin = cin;
		this.date_exam_theorique = date_exam_theorique;
		this.resultat1 = resultat1;
		this.date_exam_pratique = date_exam_pratique;
		this.resultat2 = resultat2;
		this.resultat_finale = resultat_finale;
	}
	 
	 
	
	
}
