package com.miage.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table
public class Station extends RepresentationModel<Station>  {
	@Id
	private int id;
	
	@Column 
	private int nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	} 
	
}
