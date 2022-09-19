package com.airlinq.Project_Informica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlinq.Project_Informica.entities.Role_Access;



public interface DaoRoles extends JpaRepository<Role_Access, String>{

}
