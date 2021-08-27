package com.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="moniteur")
public class Moniteur implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nom;
	private String cin;
	private String cap;
	private String telephone;
	private String numero_permis;
	private String email;
	private String type;
	private String adresse;
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNumero_permis() {
		return numero_permis;
	}
	public void setNumero_permis(String numero_permis) {
		this.numero_permis = numero_permis;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Moniteur(String nom, String cin, String cap, String telephone, String numero_permis, String email,
			String type, String adresse) {
		super();
		this.nom = nom;
		this.cin = cin;
		this.cap = cap;
		this.telephone = telephone;
		this.numero_permis = numero_permis;
		this.email = email;
		this.type = type;
		this.adresse = adresse;
	}
	public Moniteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
