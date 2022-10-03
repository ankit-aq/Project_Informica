package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airlinq.Project_Informica.entities.UserRolesMapping;

/**
 * This interface is created to implement Data Access Object(DAO) for UserRolesMapping table
 * in the database.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

public interface DaoUserRolesMapping extends JpaRepository<UserRolesMapping, Integer>{

}
