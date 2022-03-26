package com.miage.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ReservationTrainAPI {

	@RequestMapping("/")
    public String home() {
        return "Bienvenue dans notre service  de  réservation  de billets de trains";
    }

	public static void main(String[] args) {
		SpringApplication.run(ReservationTrainAPI.class, args);
       // new SpringApplicationBuilder(ReservationTrainAPI.class).web(true).run(args);
	}

}
