package com.sid.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


 
 @Entity
 @Table(name="candidat")
 public class Candidat {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 private Long id;
 private String nom;
 private String cin;
 private Date dateNaissance;
 private String adresse;
 private String tel;
 private String photo;
 private String numero_ministre;
 private String categorie_permis;
 private Date date_inscription;
 private double prix;
 private double montant_paye;
 private double montant_reste;
 

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


public Date getDateNaissance() {
	return dateNaissance;
}


public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}


public String getAdresse() {
	return adresse;
}


public void setAdresse(String adresse) {
	this.adresse = adresse;
}


public String getTel() {
	return tel;
}


public void setTel(String tel) {
	this.tel = tel;
}


public String getPhoto() {
	return photo;
}


public void setPhoto(String photo) {
	this.photo = photo;
}


public String getNumero_ministre() {
	return numero_ministre;
}


public void setNumero_ministre(String numero_ministre) {
	this.numero_ministre = numero_ministre;
}


public String getCategorie_permis() {
	return categorie_permis;
}


public void setCategorie_permis(String categorie_permis) {
	this.categorie_permis = categorie_permis;
}


public Date getDate_inscription() {
	return date_inscription;
}


public void setDate_inscription(Date date_inscription) {
	this.date_inscription = date_inscription;
}


public double getPrix() {
	return prix;
}


public void setPrix(double prix) {
	this.prix = prix;
}


public Candidat() {
	super();
	// TODO Auto-generated constructor stub
}


public Candidat(String nom,String cin, Date dateNaissance, String adresse, String tel, String photo,
		String numero_ministre, String categorie_permis, Date date_inscription, double prix) {
	super();
	this.nom = nom;
	this.cin = cin;
	this.dateNaissance = dateNaissance;
	this.adresse = adresse;
	this.tel = tel;
	this.photo = photo;
	this.numero_ministre = numero_ministre;
	this.categorie_permis = categorie_permis;
	this.date_inscription = date_inscription;
	this.prix = prix;
}


public double getMontant_paye() {
	return montant_paye;
}


public void setMontant_paye(double montant_paye) {
	this.montant_paye = montant_paye;
}


public double getMontant_reste() {
	return montant_reste;
}


public void setMontant_reste(double montant_reste) {
	this.montant_reste = montant_reste;
}


//@Transient
public String getPhotosImagePath() {
   if (photo == null || id == null) return null;
    
   return "/Candidat-photos/" + id + "/" + photo;
}
 
 }
