
package com.miage.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.miage.app.controller.VoyageController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReservationTrainAPITests {

	
	  @Autowired
	  VoyageController voyageController;
	@Test
	void contextLoads() {
	    Assertions.assertThat(voyageController).isNotNull();
	}

}
