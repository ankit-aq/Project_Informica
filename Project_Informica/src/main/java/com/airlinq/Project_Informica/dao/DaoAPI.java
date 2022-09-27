package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.API;



/**
 * This interface is created to implement Data Access Object(DAO) for api table
 * in the database.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

public interface DaoAPI extends JpaRepository<API, Integer>{

}