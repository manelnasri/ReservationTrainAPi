package com.miage.app.service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.miage.app.Train2Repository.VoyageRepository;
import com.miage.app.controller.ReservationController;
import com.miage.app.controller.VoyageController;
import com.miage.app.Train2Repository.ReservationRepository;
import com.miage.app.model.Voyage;
import com.miage.app.model.Reservation;
import com.miage.app.model.Station;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service  
public class ReservationService {


	
	@Autowired  
	ReservationRepository reservationRepository;  
	
	
	//getting all student records  
	public List<Reservation> getAllBookings()   
		{  
		List<Reservation> reservations = new ArrayList<Reservation>();  
		reservationRepository.findAll().forEach(res -> reservations.add(res));  
		
		
		for (Reservation r : reservations) {
			
			if(r.getEtatRes().equals("NON CONFIRMEE"))
			{
				ZoneId zonedId = ZoneId.of( "Europe/Paris" );
	            LocalDate today = LocalDate.now( zonedId );
	            
	            //Adding method link employee 'singular' resource
	            Reservation methodLinkBuilder2 =
	                    methodOn(ReservationController.class)
	                            .confirmBooking(r.getId());
	            Link reportLink2 =
	                    linkTo(methodLinkBuilder2).withRel("confirmer-et-payer-reservation");

	            // Add link to singular resource
	            r.add(reportLink2);
			}
            
		}
		
		return reservations;  
			
		}  
		
	
	//getting a specific record  
	public Reservation getReservationById(int id)   
	{  
			return reservationRepository.findById(id).get();  
	}  
	
	public void saveOrUpdate(Reservation res)   
	{  
		reservationRepository.save(res);  
	}  
	
	//deleting a specific record  
	public void delete(int id)   
	{  
		reservationRepository.deleteById(id);  
	}
	
}
