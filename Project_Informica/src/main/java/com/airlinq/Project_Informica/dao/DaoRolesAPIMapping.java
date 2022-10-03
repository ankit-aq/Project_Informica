package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.RolesAPIMapping;




/**
 * This interface is created to implement Data Access Object(DAO) for RolesAPIMapping table
 * in the database.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

public interface DaoRolesAPIMapping extends JpaRepository<RolesAPIMapping, Integer>{

}