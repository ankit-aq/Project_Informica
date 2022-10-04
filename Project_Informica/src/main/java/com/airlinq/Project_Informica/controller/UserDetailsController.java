package com.airlinq.Project_Informica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airlinq.Project_Informica.entities.User_Details;
import com.airlinq.Project_Informica.service.user_service.UserDetailsServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This UserDetailsController class is a controller class for User_Details entity class.
 * This controller class accepts all the HTTP requests for user_details table and send the response.  
 * 
 * @author Mahi Kumawat 
 * @version 1.0
 *
 */

@RestController
public class UserDetailsController {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	
	/**
	 * API for getting all the user details.
	 * 
	 */
	
	@GetMapping(path="/getAllUserDetails")
	@ApiOperation(value = "Fetch all user details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved"),
		@ApiResponse(code = 401, message = "Successfully retrieved")
	})
	public ResponseEntity<List<User_Details>> getAllUserDetails(){
		
		return this.userDetailsServiceImpl.getAllUserDetails();
	}
	
	/**
	 * API for fetching the user details by user_id.
	 * 
	 */
	
	@RequestMapping(value = "/getUserDetails/{user_id}", method = RequestMethod.GET)
	@ApiOperation(value = "Fetch user detail by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<Object> getUserDetails(@PathVariable @ApiParam(name = "user_id", value = "User id", example = "1") int user_id){
		return this.userDetailsServiceImpl.getUserDetails(user_id);
	}
	
	/**
	 * API for inserting user details in the user_details table in the database.
	 * 
	 */
	
	@RequestMapping(value = "/addUserDetails", method = {RequestMethod.POST })
	@ApiOperation(value = "Add user in the database")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully added")	
	})
	public ResponseEntity<User_Details> addUserDetails(@RequestBody @ApiParam(name = "Request Body", value = "Request Params") User_Details userdetails){
		System.out.println("Hello");
		return this.userDetailsServiceImpl.addUserDetails(userdetails);
	}
	
	/**
	 * API for deleting user details in the user_details table in the database using user_id.
	 * 
	 */
	
	@DeleteMapping(path="/deleteUserDetails/{user_id}")
	@ApiOperation(value = "Delete user by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully deleted")	
	})
    public ResponseEntity<String> deleteUserDetails(@PathVariable @ApiParam(name = "user_id", value = "User id", example = "1") int user_id) {

		return this.userDetailsServiceImpl.deleteUserDetails(user_id);
    }
	
}
