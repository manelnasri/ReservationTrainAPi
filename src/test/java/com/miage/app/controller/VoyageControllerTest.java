
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
import com.miage.app.model.Voyage;
import com.miage.app.service.ReservationService;
import com.miage.app.service.VoyageService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VoyageController.class)


public class VoyageControllerTest {

	
	  @MockBean
	  VoyageService voyageService;
	  @MockBean
	  ReservationService reservationService;
	 
	  
	  @Autowired
	  MockMvc mockMvc;
	  
	  
	  
	  @Test
	  public void testChercherTousLesVoyages() throws Exception {
	    Voyage voyage = new Voyage(109,"Nancy","Epinal","9:00","10:00","couloir","10","15", "2211");
	    List<Voyage> voyages = Arrays.asList(voyage);
	    //Voyage voyage2 = new Voyage(108,"Nancy","Toul","9:00","9:10","couloir","10","15");
	    //voyages.add(voyage2); 
	    
	    
	    Mockito.when(voyageService.chercherTousLesVoyages()).thenReturn(voyages);
	 
	    mockMvc.perform(get("/trains"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", Matchers.hasSize(1)))
	        .andExpect(jsonPath("$[0].station_dep", Matchers.is("Nancy")));	    
	  }
	
	  
}
