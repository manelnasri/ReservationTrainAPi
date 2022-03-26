package com.miage.app.Train2Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miage.app.model.Voyage;
import com.miage.app.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
    
   
}
