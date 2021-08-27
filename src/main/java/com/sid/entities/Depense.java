package com.sid.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="depense")
public class Depense {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String libelle;
	private double montant;
	private String type;
	private Date date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Depense(String libelle, double montant, String type, Date date) {
		super();
		this.libelle = libelle;
		this.montant = montant;
		this.type = type;
		this.date = date;
	}
	
}
