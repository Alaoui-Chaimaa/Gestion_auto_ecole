package com.sid.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Vehicule implements Serializable{
@Id

private String matricule;

private String type;

private String marque;

private Date date_assurance;

private Date date_fin_assurance;

private Date date_visite_technique;



private Date date_fin_visite_technique;

public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public Date getDate_assurance() {
	return date_assurance;
}
public void setDate_assurance(Date date_assurance) {
	this.date_assurance = date_assurance;
}
public Date getDate_fin_assurance() {
	return date_fin_assurance;
}
public void setDate_fin_assurance(Date date_fin_assurance) {
	this.date_fin_assurance = date_fin_assurance;
}
public Date getDate_visite_technique() {
	return date_visite_technique;
}
public void setDate_visite_technique(Date date_visite_technique) {
	this.date_visite_technique = date_visite_technique;
}
public Date getDate_fin_visite_technique() {
	return date_fin_visite_technique;
}
public void setDate_fin_visite_technique(Date date_fin_visite_technique) {
	this.date_fin_visite_technique = date_fin_visite_technique;
}
public Vehicule(String matricule, String type, String marque, Date date_assurance, Date date_fin_assurance,
		Date date_visite_technique, Date date_fin_visite_technique) {
	super();
	this.matricule = matricule;
	this.type = type;
	this.marque = marque;
	this.date_assurance = date_assurance;
	this.date_fin_assurance = date_fin_assurance;
	this.date_visite_technique = date_visite_technique;
	this.date_fin_visite_technique = date_fin_visite_technique;
}
public Vehicule() {
	super();
	// TODO Auto-generated constructor stub
}

	
	
}
