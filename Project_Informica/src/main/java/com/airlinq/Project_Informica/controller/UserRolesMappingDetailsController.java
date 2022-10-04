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
import com.airlinq.Project_Informica.entities.UserRolesMapping;
import com.airlinq.Project_Informica.service.user_roles_mapping_service.UserRolesMappingServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This UserRolesMappingDetailsController class is a controller class for UserRolesMapping entity class.
 * This controller class accepts all the HTTP requests for UserRolesMapping table and send the response.  
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

@RestController
public class UserRolesMappingDetailsController {

	@Autowired
	private UserRolesMappingServiceImpl userRolesMappingServiceImpl;
	
	/**
	 * API for fetching all the roles API access details from the database.
	 * 
	 */
	@GetMapping(path="/getAllUserRolesMappingDetails")
	@ApiOperation(value = "Fetch all user roles mapping details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<List<UserRolesMapping>> getAllUserRolesMappingDetails(){
		
		return this.userRolesMappingServiceImpl.getAllUserRolesMappingDetails();
	}
	
	/**
	 * API for fetching the roles API access details by roles_api_mapping_id.
	 * 
	 */
	
	@GetMapping(path="/getUserRolesMappingDetails/{user_roles_mapping_id}")
	@ApiOperation(value = "Fetch roles api mapping details by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<Object> getUserRolesMappingDetails(@PathVariable int user_roles_mapping_id){
		
		return this.userRolesMappingServiceImpl.getUserRolesMappingDetails(user_roles_mapping_id);
	}
	
	/**
	 * API for inserting roles api mapping details in the UserRolesMapping table in the database.
	 * 
	 */
	
	@PostMapping(path="/addUserRolesMappingDetails")
	@ApiOperation(value = "Add roles api mapping details in the sdsds")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully added")	
	})
	public ResponseEntity<UserRolesMapping> addUserRolesMappingDetails(@RequestBody UserRolesMapping userRolesMapping){
		
		return this.userRolesMappingServiceImpl.addUserRolesMappingDetails(userRolesMapping);
	}
	
	
	/**
	 * API for deleting roles api mapping details in the UserRolesMapping table in the database using roles_api_mapping_id..
	 * 
	 */
	@DeleteMapping(path="/deleteUserRolesMappingDetails/{user_roles_mapping_id}")
	@ApiOperation(value = "Delete roles api mapping data by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully deleted")	
	})
    public ResponseEntity<String> deleteUserRolesMappingDetails(@PathVariable int user_roles_mapping_id) {

		return this.userRolesMappingServiceImpl.deleteUserRolesMappingDetails(user_roles_mapping_id);
    }
	
	
	
}
