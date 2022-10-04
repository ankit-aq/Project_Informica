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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


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
	@ApiOperation(value = "Fetch all roles details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<List<Roles>> getAllRolesDetails(){
		
		return this.rolesServiceImpl.getAllRolesDetails();
	}
	
	/**
	 * API for fetching the role details by role_id.
	 * 
	 */
	
	@GetMapping(path="/getRolesDetails/{role_id}")
	@ApiOperation(value = "Fetch roles details by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<Object> getRolesDetail(@PathVariable @ApiParam(name = "role_id", value = "Role id", example = "1") int role_id){
		return this.rolesServiceImpl.getRolesDetails(role_id);
	}
	
	/**
	 * API for inserting role in the roles table in the database.
	 * 
	 */
	
	@PostMapping(path="/addRolesDetails")
	@ApiOperation(value = "Add role in the roles table")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully added")	
	})
	public ResponseEntity<Roles> addRolesDetails(@RequestBody @ApiParam(name = "Request Body", value = "Request Params") Roles roles){
		return this.rolesServiceImpl.addRolesDetails(roles);
	}
	
	
	/**
	 * API for deleting role in the roles table in the database using role_id.
	 * 
	 */
	@DeleteMapping(path="/deleteRolesDetails/{role_id}")
	@ApiOperation(value = "Delete role by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully deleted")	
	})
    public ResponseEntity<String> deleteRolesDetails(@PathVariable @ApiParam(name = "role_id", value = "Role id", example = "1") int role_id) {

		return this.rolesServiceImpl.deleteRolesDetails(role_id);
    }
	
}
