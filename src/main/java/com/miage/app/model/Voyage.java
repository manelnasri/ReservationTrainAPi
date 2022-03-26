package com.miage.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity(name = "VOYAGE")
@Table(name = "VOYAGE")
public class Voyage extends RepresentationModel<Voyage>{
	@Id
	private int id;
	
	@Column(name = "station_dep")
	private String stationDep; 
	
	@Column(name = "station_arr")

	private String stationArr; 
	
	@Column(name = "heure_dep")
	private String heureDep; 

	@Column(name = "heure_arr")
	private String heureArr;
	
	@Column(name = "type_place")
	private String typePlace;
	
	@Column(name = "num_train")
	private String numTrain;
	
	
	public String getNumTrain() {
		return numTrain;
	}


	public void setNumTrain(String numTrain) {
		this.numTrain = numTrain;
	}


	public String getTypePlace() {
		return typePlace;
	}


	public void setTypePlace(String typePlace) {
		this.typePlace = typePlace;
	}


	@Column(name = "tarif_aller")
	private String tarifAller;
	
	@Column(name = "tarif_allerretour")
	private String tarifAllerRetour;


	public String getTarifAller() {
		return tarifAller;
	}


	public void setTarifAller(String tarifAller) {
		this.tarifAller = tarifAller;
	}


	public String getTarifAllerRetour() {
		return tarifAllerRetour;
	}


	public void setTarifAllerRetour(String tarifAllerRetour) {
		this.tarifAllerRetour = tarifAllerRetour;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStation_dep() {
		return stationDep;
	}


	public void setStation_dep(String station_dep) {
		this.stationDep = station_dep;
	}


	public String getStation_arr() {
		return stationArr;
	}


	public void setStation_arr(String station_arr) {
		this.stationArr = station_arr;
	}


	public String getHeure_dep() {
		return heureDep;
	}


	public void setHeure_dep(String heureDep) {
		this.heureDep = heureDep;
	}


	public String getHeure_arr() {
		return heureArr;
	}


	public void setHeure_arr(String heureArr) {
		this.heureArr = heureArr;
	}


	public Voyage(int id, String stationDep, String stationArr, String heureDep, String heureArr, String typePlace,
			String numTrain, String tarifAller, String tarifAllerRetour) {
		super();
		this.id = id;
		this.stationDep = stationDep;
		this.stationArr = stationArr;
		this.heureDep = heureDep;
		this.heureArr = heureArr;
		this.typePlace = typePlace;
		this.numTrain = numTrain;
		this.tarifAller = tarifAller;
		this.tarifAllerRetour = tarifAllerRetour;
	}


	public Voyage() {
		super();
	} 
	
	
}
