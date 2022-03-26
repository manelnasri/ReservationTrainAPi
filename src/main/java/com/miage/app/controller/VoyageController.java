package com.miage.app.controller;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.miage.app.model.Voyage;
import com.miage.app.model.Reservation;
import com.miage.app.service.VoyageService;
import com.miage.app.service.ReservationService;

@RestController
public class VoyageController {
	
	
	@Autowired  
	VoyageService voyageService;  
	
	@Autowired  
	ReservationService reservationService;  
	
	
	/*
	 * création d'un mapping GET 
	 * Recherches de tous les trains disponibles 
	 */  
	@GetMapping("/trains")  
	private List<Voyage> chercherTousLesVoyages()   
	{  
			return voyageService.chercherTousLesVoyages();  
	}  
	
	/*
	 * création d'un mapping GET 
	 * Recherches d'un voyage en utilisant l'ID 
	 */ 
	@GetMapping("/trains/{trainid}")  
	private Voyage chercherTrain(@PathVariable("trainid") int trainid)   
	{  
	return voyageService.getVoyageById(trainid);  
	}  
	
	/*
	 * création d'un mapping GET 
	 * Recherches des trains pour un trajet en précisant la ville de départ et la ville d'arrivée  
	 */  
	@GetMapping("/trainsAR/{dep}/{arr}")  
	private List<Voyage> chercherVoyagesAllerRetour(@PathVariable("dep") String dep, @PathVariable("arr") String arr)   
	{  
			return voyageService.chercherVoyagesAllerRetour(dep, arr);  
	}  
	
	/*
	 * création d'un mapping GET 
	 * Recherches des trains pour un trajet Aller Simple en précisant la ville de départ et la ville d'arrivée  
	 */  
	@GetMapping("/trainsAS/{dep}/{arr}")  
	private List<Voyage> chercherVoyagesAllerSimple(@PathVariable("dep") String dep, @PathVariable("arr") String arr)   
	{  
			return voyageService.chercherVoyagesAllerSimple(dep, arr);  
	}  
	
	/*
	 * création d'un mapping GET 
	 * Recherches des trains pour un trajet AS   en précisant la ville de départ et la ville d'arrivée et le type de place
	 */  
	@GetMapping("/trainsAS/{dep}/{arr}/{type}")  
	private List<Voyage> chercherVoyagesAllerSimpleTypePlace(@PathVariable("dep") String dep, @PathVariable("arr") String arr, @PathVariable("type") String type_place)   
	{  
			return voyageService.chercherVoyagesAllerSimpleTypePlace(dep, arr, type_place);  
	}  
	
	/*
	 * création d'un mapping GET 
	 * Recherches des trains pour un trajet AR en précisant la ville de départ et la ville d'arrivée et le type de place
	 */  
	@GetMapping("/trainsAR/{dep}/{arr}/{type}")  
	private List<Voyage> chercherVoyagesAllerRetourTypePlace(@PathVariable("dep") String dep, @PathVariable("arr") String arr, @PathVariable("type") String type_place)   
	{  
			return voyageService.chercherVoyagesAllerRetourTypePlace(dep, arr, type_place);  
	}  
	
	
	/*
	 * création d'un mapping GET 
	 * Recherches des trains pour un trajet AS en précisant la ville de départ et la ville d'arrivée, le type de place et l'horaire
	 */  
	
	@GetMapping("/trainsAS/{dep}/{arr}/{type}/{horaire}")  
	private List<Voyage> chercherVoyagesAllerSimpleTypePlaceHoraire(@PathVariable("dep") String dep, @PathVariable("arr") String arr, @PathVariable("type") String type_place, @PathVariable("horaire") String horaire)   
	{  
			return voyageService.chercherVoyagesAllerSimpleTypePlaceHoraire(dep, arr, type_place, horaire);  
	}  
	
	/*
	 * création d'un mapping GET 
	 * Recherches des trains AR pour un trajet en précisant la ville de départ et la ville d'arrivée, le type de place et l'horaire
	 */  
	
	@GetMapping("/trainsAR/{dep}/{arr}/{type}/{horaire}")  
	private List<Voyage> chercherVoyagesAllerRetourTypePlaceHoraire(@PathVariable("dep") String dep, @PathVariable("arr") String arr, @PathVariable("type") String type_place, @PathVariable("horaire") String horaire)   
	{  
			return voyageService.chercherVoyagesAllerRetourTypePlaceHoraire(dep, arr, type_place, horaire);  
	} 
	
	
	/*
	 * création d'un mapping GET 
	 * Création d'un réservation lorsque l'utilisateur clique  sur le lien HATEOS
	 */  
	@GetMapping("/reservation/{id_voyage}/{type_place}/{type_trajet}/{prix_trajet}")
    public Reservation makeBooking(@PathVariable("id_voyage") int id_v, @PathVariable("type_place") String type_p, @PathVariable("type_trajet") String type_trajet,@PathVariable("prix_trajet") String prix_trajet )
	{ 
		// Do some operation and return report
		Reservation r = new Reservation (); 
        ZoneId zonedId = ZoneId.of( "America/Montreal" );
        LocalDate today = LocalDate.now( zonedId );
		r.setVoyageId(id_v);
		r.setTypePlace(type_p);
		r.setTypeTrajet(type_trajet);
		r.setDateRes(today.toString());
		r.setPrixRes(prix_trajet); 		
		r.setEtatRes("NON CONFIRMEE");
		System.out.println(r);
         reservationService.saveOrUpdate(r);
		return r;
    }
	
		
}
