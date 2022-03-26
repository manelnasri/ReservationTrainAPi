package com.miage.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.hateoas.RepresentationModel;

@Entity(name = "RESERVATION")
@Table(name = "RESERVATION")
public class Reservation extends RepresentationModel<Reservation>{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name = "voyage_id")
	private int voyageId; 
	
	@Column(name = "date_res")

	private String dateRes; 
	
	@Column(name = "type_place")
	private String typePlace; 

	@Column(name = "type_trajet")
	private String typeTrajet;

	@Column(name = "prix_res")
	private String prixRes;
	
	@Column(name = "etat_res")
	@ColumnDefault(value = "'Toyota'")
	private String etatRes;
	
	public String getEtatRes() {
		return etatRes;
	}

	public void setEtatRes(String etatRes) {
		this.etatRes = etatRes;
	}

	public String getTypePlace() {
		return typePlace;
	}

	public void setTypePlace(String typePlace) {
		this.typePlace = typePlace;
	}


	public Reservation() {

	}

	public Reservation(int id, int voyageId, String dateRes, String typePlace, String typeTrajet, String prixRes) {
		super();
		this.id = id;
		this.voyageId = voyageId;
		this.dateRes = dateRes;
		this.typePlace = typePlace;
		this.typeTrajet = typeTrajet;
		this.prixRes = prixRes;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getVoyageId() {
		return voyageId;
	}


	public void setVoyageId(int voyageId) {
		this.voyageId = voyageId;
	}


	public String getDateRes() {
		return dateRes;
	}


	public void setDateRes(String dateRes) {
		this.dateRes = dateRes;
	}


	public String getTypeTrajet() {
		return typeTrajet;
	}


	public void setTypeTrajet(String typeTrajet) {
		this.typeTrajet = typeTrajet;
	}


	public String getPrixRes() {
		return prixRes;
	}


	public void setPrixRes(String prixRes) {
		this.prixRes = prixRes;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", voyageId=" + voyageId + ", dateRes=" + dateRes + ", typePlace=" + typePlace
				+ ", typeTrajet=" + typeTrajet + ", prixRes=" + prixRes + "]";
	}


}
