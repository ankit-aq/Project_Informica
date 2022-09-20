package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.Products;

/**
 * This interface is created to implement Data Access Object(DAO) for products table
 * in the database.
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 */


public interface DaoProduct extends JpaRepository<Products, Integer>{

}
