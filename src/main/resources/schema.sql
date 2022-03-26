    
        DROP TABLE IF EXISTS STATION CASCADE CONSTRAINTS;  
    CREATE TABLE STATION (  
    id INT AUTO_INCREMENT  PRIMARY KEY,  
    nom VARCHAR(50) NOT NULL 
    );  

        DROP TABLE IF EXISTS VOYAGE CASCADE CONSTRAINTS;  
    CREATE TABLE VOYAGE (  
    id INT AUTO_INCREMENT  PRIMARY KEY,  
    station_dep VARCHAR(50) NOT NULL,
    station_arr VARCHAR(50) NOT NULL,
    heure_dep VARCHAR(50) NOT NULL,
    heure_arr VARCHAR(50) NOT NULL,
    type_place VARCHAR(50) NOT NULL,
    tarif_aller VARCHAR(50) NOT NULL,
    tarif_allerretour VARCHAR(50) NOT NULL,
        num_train VARCHAR(50) NOT NULL
    
    );  
    
    
      DROP TABLE IF EXISTS RESERVATION CASCADE CONSTRAINTS;  
    CREATE TABLE RESERVATION (  
    id INT AUTO_INCREMENT  PRIMARY KEY,  
    voyage_id INT NOT NULL,
    date_res VARCHAR(50),
    type_place VARCHAR(50) ,
    type_trajet VARCHAR(50) ,
    prix_res VARCHAR(50),
    etat_res VARCHAR(50) DEFAULT 'Non confirmée'
    );  
    
 