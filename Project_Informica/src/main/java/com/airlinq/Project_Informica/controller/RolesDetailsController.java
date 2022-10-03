package com.airlinq.Project_Informica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.airlinq.Project_Informica.entities.Roles;
import com.airlinq.Project_Informica.service.roles_service.RolesServiceImpl;


/**
 * This RolesDetailsController class is a controller class for Roles entity class.
 * This controller class accepts all the HTTP requests for roles table and send the response.  
 * 
 * @author Ankit Sharma 
 * @version 1.0
 *
 */

@RestController
public class RolesDetailsController {

	@Autowired
	private RolesServiceImpl rolesServiceImpl;
	
	
	/**
	 * API for fetching all the roles details from the database.
	 * 
	 */
	@GetMapping(path="/getAllRolesDetails")
	public ResponseEntity<List<Roles>> getAllRolesDetails(){
		
		return this.rolesServiceImpl.getAllRolesDetails();
	}
	
	/**
	 * API for fetching the role details by role_id.
	 * 
	 */
	
	@GetMapping(path="/getRolesDetails/{role_id}")
	public ResponseEntity<Object> getRolesDetail(@PathVariable int role_id){
		return this.rolesServiceImpl.getRolesDetails(role_id);
	}
	
	/**
	 * API for inserting role in the roles table in the database.
	 * 
	 */
	
	@PostMapping(path="/addRolesDetails")
	public ResponseEntity<Roles> addRolesDetails(@RequestBody Roles roles){
		return this.rolesServiceImpl.addRolesDetails(roles);
	}
	
	
	/**
	 * API for deleting role in the roles table in the database using role_id.
	 * 
	 */
	@DeleteMapping(path="/deleteRolesDetails/{role_id}")
    public ResponseEntity<String> deleteRolesDetails(@PathVariable int role_id) {

		return this.rolesServiceImpl.deleteRolesDetails(role_id);
    }
	
}
