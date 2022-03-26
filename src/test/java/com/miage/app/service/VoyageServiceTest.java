package com.miage.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miage.app.Train2Repository.VoyageRepository;
import com.miage.app.model.Voyage;

@ExtendWith(MockitoExtension.class)
public class VoyageServiceTest {

	@InjectMocks
	 VoyageService voyageService2;
	 @Mock
	  VoyageRepository voyageRepository;
	 
	 @Test
	  public void testChercherVoyagesAllerSimple() throws Exception {
		    Voyage voyage1 = new Voyage(109,"Nancy","Metz","9:00","10:00","couloir","10","15","2333");
		    Voyage voyage2 = new Voyage(109,"Metz","Nancy","11:00","12:00","couloir","10","15","3211");
		    List<Voyage> voyages = new ArrayList<Voyage>();
		    voyages.add(voyage2);
		    voyages.add(voyage1);

		    
		    when(voyageRepository.findByStationDepAndStationArrLike("Nancy", "Metz"))
		    .thenReturn(Arrays.asList(voyage1));

		    List<Voyage> liste = voyageService2.chercherVoyagesAllerSimple("Nancy", "Metz");
	          
	        assertEquals(1, liste.size());	        
	        
	        
		  }
	 
	 @Test
	  public void testChercherVoyagesAllerRetour() throws Exception {
		    Voyage voyage1 = new Voyage(109,"Nancy","Metz","9:00","10:00","couloir","10","15","2333");
		    Voyage voyage2 = new Voyage(109,"Metz","Nancy","11:00","12:00","couloir","10","15","3211");

		    List<Voyage> voyages = new ArrayList<Voyage>();
		    voyages.add(voyage2);
		    voyages.add(voyage1);

		    
		    when(voyageRepository.findByStationDepAndStationArrLike("Nancy", "Metz"))
		    .thenReturn(Arrays.asList(voyage1));

		    List<Voyage> liste = voyageService2.chercherVoyagesAllerRetour("Nancy", "Metz");
	          
	        assertEquals(1, liste.size());	        
	        
	        
		  }
	 @Test
	  public void testChercherVoyagesAllerSimpleTypePlace() throws Exception {
		    Voyage voyage1 = new Voyage(109,"Nancy","Metz","9:00","10:00","couloir","10","15","2333");
		    Voyage voyage2 = new Voyage(109,"Metz","Nancy","11:00","12:00","fenêtre","10","15","3211");

		    List<Voyage> voyages = new ArrayList<Voyage>();
		    voyages.add(voyage2);
		    voyages.add(voyage1);

		    
		    when(voyageRepository.findByStationDepAndStationArrAndTypePlaceLike("Nancy", "Metz","couloir"))
		    .thenReturn(Arrays.asList(voyage1));

		    List<Voyage> liste = voyageService2.chercherVoyagesAllerSimpleTypePlace("Nancy", "Metz","couloir");
	          
	        assertEquals(1, liste.size());	        
	        
	        
		  }
	 
	 @Test
	  public void testChercherVoyagesAllerRetourTypePlace() throws Exception {
		    Voyage voyage1 = new Voyage(109,"Nancy","Metz","9:00","10:00","couloir","10","15","2333");
		    Voyage voyage2 = new Voyage(109,"Metz","Nancy","11:00","12:00","fenêtre","10","15","3211");

		    List<Voyage> voyages = new ArrayList<Voyage>();
		    voyages.add(voyage2);
		    voyages.add(voyage1);

		    
		    when(voyageRepository.findByStationDepAndStationArrAndTypePlaceLike("Nancy", "Metz","couloir"))
		    .thenReturn(Arrays.asList(voyage1));

		    List<Voyage> liste = voyageService2.chercherVoyagesAllerRetourTypePlace("Nancy", "Metz","couloir");
	          
	        assertEquals(1, liste.size());	        
	        
	        
		  }
	 
}
