package com.miage.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.app.model.Voyage;
import com.miage.app.model.Reservation;
import com.miage.app.service.VoyageService;
import com.miage.app.service.ReservationService;

@RestController
public class ReservationController {
	
	
	@Autowired  
	ReservationService reservationService;  	
	
	/*
	 * création d'un mapping GET 
	 * Recherches de toutes les reservations  
	 */  
	@GetMapping("/reservations")  
	private List<Reservation> getAllBookings()   
	{  
		return reservationService.getAllBookings();  
	}

	/*
	 * création d'un mapping GET 
	 * Confirmation d'une réservation avec l'id  
	 */  
	@GetMapping("/confirmer-reservation/{id}") 
	public Reservation confirmBooking(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		Reservation r = reservationService.getReservationById(id); 
		r.setEtatRes("CONFIRMEE"); 
		reservationService.saveOrUpdate(r);
		return r;
	}
	
}
