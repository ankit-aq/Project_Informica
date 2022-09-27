package com.airlinq.Project_Informica.service.roles_service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.entities.Roles;

/**
 * This RolesService interface declares all the required function needed in RolesServiceImpl class.
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

@Service
public interface RolesService {

	public ResponseEntity<List<Roles>> getAllRolesDetails();
	
	public ResponseEntity<Object> getRolesDetails(int role_id);
	
	public ResponseEntity<Roles> addRolesDetails(Roles roles);
	
	public ResponseEntity<String> deleteRolesDetails(int role_id);
	
}
