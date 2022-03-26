package com.miage.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miage.app.Train2Repository.ReservationRepository;
import com.miage.app.Train2Repository.VoyageRepository;
import com.miage.app.model.Reservation;
import com.miage.app.model.Voyage;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

	@InjectMocks
	 ReservationService reservationService2;
	 @Mock
	  ReservationRepository reservationRepository;
	 

	 @Test
	  public void testChercherReservations() throws Exception {
		    Reservation r1 = new Reservation(1,1,"12/03/2022","couloir","NON CONFIRMEE","20");
		    Reservation r2 = new Reservation(2,1,"13/03/2022","couloir","NON CONFIRMEE","10");


		    List<Reservation> reservations = new ArrayList<Reservation>();
		    reservations.add(r1);
		    reservations.add(r2);

		    
		    when(reservationService2.getAllBookings())
		    .thenReturn(reservations);

		    List<Reservation> res = (List<Reservation>) reservationRepository.findAll();  //.chercherVoyagesAllerRetourTypePlace("Nancy", "Metz","couloir");
	          
	        assertEquals(2,res.size());	        
	        
	        
		  }
	 
}
