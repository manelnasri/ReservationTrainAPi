package com.miage.app.Train2Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miage.app.model.Voyage;


public interface VoyageRepository extends JpaRepository<Voyage, Integer>, CrudRepository<Voyage, Integer>{
    List<Voyage> findByStationDepLike(String dep);
    List<Voyage> findByStationDepAndStationArrLike(String dep, String arr);
    List<Voyage> findByStationDepAndStationArrAndTypePlaceLike(String dep, String arr, String type_place);

    
    
    //List<HoraireVoyage> rechercherTrajets(String dep);

	/*
	  JdbcTemplate jdbctemplate;
	 
	
	 
	    public int count() {
	        return jdbctemplate.queryForObject("select count(*) from horairevoyage", Integer.class);
	    }
	 */
}
