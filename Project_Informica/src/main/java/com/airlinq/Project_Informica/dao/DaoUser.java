package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.User_Details;

public interface DaoUser extends JpaRepository<User_Details, String>{

}
