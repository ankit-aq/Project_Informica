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
import com.airlinq.Project_Informica.service.api_entity_service.APIDetailsServiceImpl;
import com.airlinq.Project_Informica.service.roles_service.RolesServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This APIDetailsController class is a controller class for API entity class.
 * This controller class accepts all the HTTP requests for API table and send the response.  
 * 
 * @author Ankit Sharma 
 * @version 1.0
 *
 */

@RestController
@Api(value = "API Controller")
public class APIDetailsController {

	
	@Autowired
	private APIDetailsServiceImpl apiDetailsServiceImpl;
	
	
	/**
	 * API for fetching all the user API access details from the database.
	 * 
	 */
	@GetMapping(path="/getAllAPIDetails")
	@ApiOperation(value = "Get all APIs from the database")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<List<API>> getAllAPIDetails(){
		
		return this.apiDetailsServiceImpl.getAllAPIDetails();
	}
	
	/**
	 * API for fetching the user API access details by api_id.
	 * 
	 */
	
	@GetMapping(path="/getAPIDetails/{api_id}")
	@ApiOperation(value = "Get API fby Id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<Object> getAPIDetails(@PathVariable int api_id){
		return this.apiDetailsServiceImpl.getAPIDetails(api_id);
	}
	
	/**
	 * API for inserting user API access details in the API table in the database.
	 * 
	 */
	
	@PostMapping(path="/addAPIDetails")
	@ApiOperation(value = "Add API in the API Table")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully added")	
	})
	public ResponseEntity<API> addAPIDetails(@RequestBody API apis){
		return this.apiDetailsServiceImpl.addAPIDetails(apis);
	}
	
	
	/**
	 * API for deleting API details in the API table in the database using api_id.
	 * 
	 */
	@DeleteMapping(path="/deleteAPIDetails/{role_id}")
	@ApiOperation(value = "Delete Api from the database")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully deleted")	
	})
    public ResponseEntity<String> deleteAPIDetails(@PathVariable int role_id) {

		return this.apiDetailsServiceImpl.deleteAPIDetails(role_id);
    }
	
}
