package com.airlinq.Project_Informica.service.api_entity_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.dao.DaoAPI;
import com.airlinq.Project_Informica.dao.DaoRoles;
import com.airlinq.Project_Informica.entities.API;
import com.airlinq.Project_Informica.entities.Roles;
import com.airlinq.Project_Informica.exception.ResourceNotFoundException;
import com.airlinq.Project_Informica.service.api_permission.ApiPermission;
	
/**
 * The APIDetailsServiceImpl class defines all the APIDetailsService interface methods.
 * All the methods in this class will be invoked by the APIDetailsController class
 * for accepting the request and giving the response.
 * 
 * @author Mahi Kumawat
 * @version 1.0
 *
 */

@Service
public class APIDetailsServiceImpl implements ApiDetailsService{
	
	String qry;
	
	@Autowired
	private DaoAPI daoAPI;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ApiPermission userRolesAccess;
	
	/**
	 * API for fetching all the user API access details from the database.
	 * 
	 */

	@Override
	public ResponseEntity<List<API>> getAllAPIDetails() {
		
		if(userRolesAccess.permission("getAllAPIDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		List<API> datalist = daoAPI.findAll();
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

	/**
	 * API for fetching the user API access details by api_id.
	 * 
	 */
	@Override
	public ResponseEntity<Object> getAPIDetails(int api_id) {
		
		if(userRolesAccess.permission("getRAPIDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select * from api where api_id = " + api_id + ";";
		
		List<Map<String, Object>> api_details = jdbcTemplate.queryForList(qry);
		
		if(api_details.isEmpty() == true) {

			throw new ResourceNotFoundException("User not found");
		}
		return new ResponseEntity<>(api_details.get(0), HttpStatus.OK);

	}

	
	/**
	 * API for inserting user API access details in the API table in the database.
	 * 
	 */
	
	@Override
	public ResponseEntity<API> addAPIDetails(API apis) {
		
		if(userRolesAccess.permission("addAPIDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		daoAPI.save(apis);
		return new ResponseEntity<>(apis,HttpStatus.OK);
	}

	/**
	 * API for deleting API details in the API table in the database using api_id.
	 * 
	 */
	@Override
	public ResponseEntity<String> deleteAPIDetails(int api_id) {
		
		if(userRolesAccess.permission("deleteAPIDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		qry = "Delete from api where api_id = " + api_id +";"; 
		jdbcTemplate.execute(qry);
		return new ResponseEntity<>("User Deleted!",HttpStatus.OK);
	}

}
