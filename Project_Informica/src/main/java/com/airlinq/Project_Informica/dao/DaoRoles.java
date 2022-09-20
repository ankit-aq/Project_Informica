package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.Role_Access;

/**
 * This interface is created to implement Data Access Object(DAO) for role_access table
 * in the database.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

public interface DaoRoles extends JpaRepository<Role_Access, String>{

}
