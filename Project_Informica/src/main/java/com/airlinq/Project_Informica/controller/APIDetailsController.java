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

import com.airlinq.Project_Informica.entities.API;
import com.airlinq.Project_Informica.entities.Roles;
import com.airlinq.Project_Informica.service.apientity_service.APIDetailsServiceImpl;
import com.airlinq.Project_Informica.service.roles_service.RolesServiceImpl;

@RestController
public class APIDetailsController {

	
	@Autowired
	private APIDetailsServiceImpl apiDetailsServiceImpl;
	
	
	/**
	 * API for fetching all the user API access details from the database.
	 * 
	 */
	@GetMapping(path="/getAllAPIDetails")
	public ResponseEntity<List<API>> getAllAPIDetails(){
		
		return this.apiDetailsServiceImpl.getAllAPIDetails();
	}
	
	/**
	 * API for fetching the user API access details by user_email.
	 * 
	 */
	
	@GetMapping(path="/getAPIDetails/{api_id}")
	public ResponseEntity<Object> getAPIDetails(@PathVariable int api_id){
		return this.apiDetailsServiceImpl.getAPIDetails(api_id);
	}
	
	/**
	 * API for inserting user API access details in the role_access table in the database.
	 * 
	 */
	
	@PostMapping(path="/addAPIDetails")
	public ResponseEntity<API> addAPIDetails(@RequestBody API apis){
		return this.apiDetailsServiceImpl.addAPIDetails(apis);
	}
	
	
	/**
	 * API for deleting role details in the role_access table in the database using role_id.
	 * 
	 */
	@DeleteMapping(path="/deleteAPIDetails/{role_id}")
    public ResponseEntity<String> deleteAPIDetails(@PathVariable int role_id) {

		return this.apiDetailsServiceImpl.deleteAPIDetails(role_id);
    }
	
}
