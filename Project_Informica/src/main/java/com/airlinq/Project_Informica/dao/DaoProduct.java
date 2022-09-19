package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.Products;

public interface DaoProduct extends JpaRepository<Products, Integer>{

}
