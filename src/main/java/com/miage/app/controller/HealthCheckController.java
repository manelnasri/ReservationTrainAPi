package com.miage.app.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HealthCheckController {
	
	/*
	 * création d'un mapping GET 
	 * Pour la vérification de l'état de l'API 
	 */  
    @GetMapping("/health-check")
    public String healthCheck() {
        return "Les service de réservation de billets de train est OK !";
    }
}