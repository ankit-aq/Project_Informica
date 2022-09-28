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
import com.airlinq.Project_Informica.entities.RolesAPIMapping;
import com.airlinq.Project_Informica.service.roles_api_mapping.RolesAPIMappingDetailsServiceImpl;

@RestController
public class RolesAPIMappingDetailsController {

	@Autowired
	private RolesAPIMappingDetailsServiceImpl rolesAPIMappingDetailsServiceImpl;
	
	/**
	 * API for fetching all the user API access details from the database.
	 * 
	 */
	@GetMapping(path="/getAllRolesAPIMappingDetails")
	public ResponseEntity<List<RolesAPIMapping>> getAllRolesAPIMappingDetails(){
		
		return this.rolesAPIMappingDetailsServiceImpl.getAllRolesAPIMappingDetails();
	}
	
	/**
	 * API for fetching the user API access details by user_email.
	 * 
	 */
	
	@GetMapping(path="/getRolesAPIMappingDetails/{roles_api_mapping_id}")
	public ResponseEntity<Object> getRolesAPIMappingDetails(@PathVariable int roles_api_mapping_id){
		
		return this.rolesAPIMappingDetailsServiceImpl.getRolesAPIMappingDetails(roles_api_mapping_id);
	}
	
	/**
	 * API for inserting user API access details in the role_access table in the database.
	 * 
	 */
	
	@PostMapping(path="/addRolesAPIMappingDetails")
	public ResponseEntity<RolesAPIMapping> addRolesAPIMappingDetails(@RequestBody RolesAPIMapping rolesAPIMapping){
		
		return this.rolesAPIMappingDetailsServiceImpl.addRolesAPIMappingDetails(rolesAPIMapping);
	}
	
	
	/**
	 * API for deleting role details in the role_access table in the database using role_id.
	 * 
	 */
	@DeleteMapping(path="/deleteRolesAPIMappingDetails/{roles_api_mapping_id}")
    public ResponseEntity<String> deleteRolesAPIMappingDetails(@PathVariable int roles_api_mapping_id) {

		return this.rolesAPIMappingDetailsServiceImpl.deleteRolesAPIMappingDetails(roles_api_mapping_id);
    }
	
	
}
