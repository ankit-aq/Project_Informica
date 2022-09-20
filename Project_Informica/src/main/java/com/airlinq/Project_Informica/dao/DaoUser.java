package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.User_Details;

/**
 * This interface is created to implement Data Access Object(DAO) for user_details table
 * in the database.
 * 
 * @author Mahi Kumawat
 * @version 1.0
 */

public interface DaoUser extends JpaRepository<User_Details, String>{

}
