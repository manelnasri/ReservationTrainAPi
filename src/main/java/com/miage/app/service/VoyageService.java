package com.miage.app.service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.miage.app.Train2Repository.VoyageRepository;
import com.miage.app.controller.ReservationController;
import com.miage.app.controller.VoyageController;
import com.miage.app.model.Voyage;
import com.miage.app.model.Reservation;
import com.miage.app.model.Station;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service  
public class VoyageService {

	@Autowired  
	VoyageRepository voyageRepository;  
	
	/*
	 * chercher tous les voyages disponibles 
	 */
	public List<Voyage> chercherTousLesVoyages()   
	{  
		List<Voyage> voyages = new ArrayList<Voyage>();  
		voyageRepository.findAll().forEach(voyage -> voyages.add(voyage));  
		return voyages;  
	}  
	
	/*
	 * chercher un voyage par id  
	 */
	public  Voyage getVoyageById(int id)   
	{  
		Voyage voyage = 
		voyageRepository.findById(id).get();  
		return voyage;  
	}  
	
		
	/*
	 * Chercher les voyages pour un aller simple 
	 */
	public List<Voyage> chercherVoyagesAllerSimple(String dep, String arr)   
	{  
		
				List<Voyage> voyages = new ArrayList<Voyage>(); 

				voyageRepository.findByStationDepAndStationArrLike(dep, arr).forEach(voyage -> voyages.add(voyage));  
				
				for (Voyage v : voyages) {
		            ZoneId zonedId = ZoneId.of( "Europe/Paris" );
		            LocalDate today = LocalDate.now( zonedId );
		            
		            //Préparation du lien HATEOS
		            Reservation lienReservation =
		                    methodOn(VoyageController.class)
		                            .makeBooking(v.getId(),v.getTypePlace(), "ALLER SIMPLE", v.getTarifAller());
		            
		            Link link =
		                    linkTo(lienReservation).withRel("Réservation en Aller Simple");

		            // Ajout du lien 
		            v.add(link);
				
				}
				
				return voyages;  
		}  
		
		//Chercher les trains pour un aller retour 
		public List<Voyage> chercherVoyagesAllerRetour(String dep, String arr)   
		{  
						List<Voyage> voyages = new ArrayList<Voyage>(); 
						voyageRepository.findByStationDepAndStationArrLike(dep, arr).forEach(voyage -> voyages.add(voyage));  						
						for (Voyage v : voyages) {

				            ZoneId zonedId = ZoneId.of( "Europe/Paris" );
				            LocalDate today = LocalDate.now( zonedId );
				            
				           //Préparation du lien HATEOS pour une réservation Aller Simple
				            Reservation lienReservation =
				                    methodOn(VoyageController.class)
				                            .makeBooking(v.getId(),v.getTypePlace(), "ALLER SIMPLE", v.getTarifAller());
				            Link link =
				                    linkTo(lienReservation).withRel("Réservation en Aller Simple");
				            //Ajout du lien 
				            v.add(link);
				            
					          //Préparation du lien HATEOS pour une réservation Aller Retour
				             lienReservation =
				                    methodOn(VoyageController.class)
				                            .makeBooking(v.getId(),v.getTypePlace(), "ALLER RETOUR", v.getTarifAllerRetour());
				            link =
				                    linkTo(lienReservation).withRel("Réservation en Aller Retour");

				            // Ajout du lien 
				            v.add(link);
						}
						
				return voyages;  
			}  
				
				
	
		/*
		 * Chercher les trains pour un aller simple et un type de place donné
		 */
		public List<Voyage> chercherVoyagesAllerSimpleTypePlace(String dep, String arr, String typePlace)   
		{
				List<Voyage> voyages = new ArrayList<Voyage>(); 
				voyageRepository.findByStationDepAndStationArrAndTypePlaceLike(dep, arr, typePlace).forEach(voyage -> voyages.add(voyage));  			
				for (Voyage v : voyages) {
		            ZoneId zonedId = ZoneId.of( "Europe/Paris" );
		            LocalDate today = LocalDate.now( zonedId );
		            
		            //Adding method link employee 'singular' resource
		            Reservation reservation =
		                    methodOn(VoyageController.class)
				                            .makeBooking(v.getId(),v.getTypePlace(), "ALLER SIMPLE", v.getTarifAller());
				            Link link =
				                    linkTo(reservation).withRel("Réservation en Aller Simple");

				            // ajout du lien 
				            v.add(link);
						}
						
				return voyages;  
			} 
		
		/*
		 * Chercher les trains pour un aller retour et un type de place donné
		 */
		public List<Voyage> chercherVoyagesAllerRetourTypePlace(String dep, String arr, String typePlace)   
		{
				List<Voyage> voyages = new ArrayList<Voyage>(); 
				voyageRepository.findByStationDepAndStationArrAndTypePlaceLike(dep, arr, typePlace).forEach(voyage -> voyages.add(voyage));  			
				for (Voyage v : voyages) {
					

		            ZoneId zonedId = ZoneId.of( "Europe/Paris" );
		            LocalDate today = LocalDate.now( zonedId );
		            
		            //Adding method link employee 'singular' resource
		            Reservation methodLinkBuilder2 =
		            methodOn(VoyageController.class)
						 .makeBooking(v.getId(),v.getTypePlace(), "ALLER RETOUR", v.getTarifAllerRetour());
						            Link reportLink2 =
						                    linkTo(methodLinkBuilder2).withRel("Réservation en Aller Retour");

						            // Add link to singular resource
						            v.add(reportLink2);								
					}
								
			return voyages;  
		} 
		
		
		/*
		 * Chercher les trains pour un aller simple, un type de place donné et un horaire donné
		 */
		public List<Voyage> chercherVoyagesAllerSimpleTypePlaceHoraire(String dep, String arr, String typePlace, String horaire)   
		{
								Calendar now = new GregorianCalendar();
								String[] parts1 = horaire.split(":");
								int horaHour1 = Integer.valueOf(parts1[0]);
								int horaMinute1 = Integer.valueOf(parts1[1]);
								List<Voyage> voyages = new ArrayList<Voyage>();  
								List<Voyage> voyagesFiltered = new ArrayList<Voyage>();  
								voyageRepository.findByStationDepAndStationArrAndTypePlaceLike(dep, arr, typePlace).forEach(voyage -> voyages.add(voyage));  
								
								for (Voyage v : voyages) {	
									String[] parts2 = v.getHeure_dep().split(":");
									int horaHour2 = Integer.valueOf(parts2[0]);
									int horaMinute2 = Integer.valueOf(parts2[1]);
									
									//si l'horaire du voyage est supérieur à l'horaire rcherché
									if(60 * horaHour2 + horaMinute2 >= 60 * horaHour1 + horaMinute1) {

										 ZoneId zonedId = ZoneId.of( "Europe/Paris" );
								            LocalDate today = LocalDate.now( zonedId );
								            
								            //Adding method link employee 'singular' resource
								            Reservation methodLinkBuilder2 =
								                    methodOn(VoyageController.class)
								                            .makeBooking(v.getId(),v.getTypePlace(), "ALLER SIMPLE", v.getTarifAller());
								            Link reportLink2 =
								                    linkTo(methodLinkBuilder2).withRel("Réservation en Aller Simple");

								            // Add link to singular resource
								            v.add(reportLink2);
								            voyagesFiltered.add(v);
									}        
								}
								
								return voyagesFiltered;  
					} 
				
						
						
	/*
	 * Chercher les trains pour un aller retour et un type de place donné
	 */
	public List<Voyage> chercherVoyagesAllerRetourTypePlaceHoraire(String dep, String arr, String typePlace, String horaire)   
	{
		Calendar now = new GregorianCalendar();
		String[] parts1 = horaire.split(":");
		int horaHour1 = Integer.valueOf(parts1[0]);
		int horaMinute1 = Integer.valueOf(parts1[1]);
							
							
							
		List<Voyage> voyages = new ArrayList<Voyage>(); 
		List<Voyage> voyagesFiltered = new ArrayList<Voyage>();  

		voyageRepository.findByStationDepAndStationArrAndTypePlaceLike(dep, arr, typePlace).forEach(voyage -> voyages.add(voyage));  
								
		for (Voyage v : voyages) {
			String[] parts2 = v.getHeure_dep().split(":");
			int horaHour2 = Integer.valueOf(parts2[0]);
			int horaMinute2 = Integer.valueOf(parts2[1]);
									
			if(60 * horaHour2 + horaMinute2 >= 60 * horaHour1 + horaMinute1) {

				ZoneId zonedId = ZoneId.of( "Europe/Paris" );
				LocalDate today = LocalDate.now( zonedId );
						            
				//Adding method link employee 'singular' resource
				Reservation methodLinkBuilder2 =
						            methodOn(VoyageController.class)
										 .makeBooking(v.getId(),v.getTypePlace(), "ALLER RETOUR", v.getTarifAllerRetour());
				Link reportLink2 =
				linkTo(methodLinkBuilder2).withRel("Réservation en Aller Retour");

				 // Add link to singular resource
				v.add(reportLink2);
				voyagesFiltered.add(v);
			}
		}
												
		return voyagesFiltered;  
	} 						
	
	//getting a specific record  
	public Voyage getHoraireById(int id)   
	{  
	return voyageRepository.findById(id).get();  
	}  
	
	public void saveOrUpdate(Voyage horaire)   
	{  
		voyageRepository.save(horaire);  
	}  
	
	//deleting a specific record  
	public void delete(int id)   
	{  
		voyageRepository.deleteById(id);  
	}
	
}
