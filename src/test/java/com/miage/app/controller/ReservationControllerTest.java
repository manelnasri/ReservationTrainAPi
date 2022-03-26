
package com.miage.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.miage.app.Train2Repository.VoyageRepository;
import com.miage.app.model.Reservation;
import com.miage.app.model.Voyage;
import com.miage.app.service.ReservationService;
import com.miage.app.service.VoyageService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationController.class)


public class ReservationControllerTest {

	
	  @MockBean
	  ReservationService reservationService;
	  
	  
	  @Autowired
	  MockMvc mockMvc;
	  

	  @Test
	  public void testChercherToutesLesReservations() throws Exception {
		  
		    Reservation r1 = new Reservation(1,1,"12/03/2022","couloir","NON CONFIRMEE","20");
		    Reservation r2 = new Reservation(2,1,"13/03/2022","couloir","NON CONFIRMEE","10");

		    List<Reservation> reservations = new ArrayList<Reservation>();
		    reservations.add(r1);
		    reservations.add(r2);
		    	    
	    
	    Mockito.when(reservationService.getAllBookings()).thenReturn(reservations);
	 
	    mockMvc.perform(get("/reservations"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$[0].dateRes", Matchers.is("12/03/2022")));	    
	    
	  }
	
	  
}
