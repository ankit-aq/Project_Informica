	package com.airlinq.Project_Informica.service.roles_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.airlinq.Project_Informica.dao.DaoRoles;
import com.airlinq.Project_Informica.entities.Roles;
import com.airlinq.Project_Informica.exception.ResourceNotFoundException;
import com.airlinq.Project_Informica.service.api_permission.ApiPermission;

/**
 * The RolesServiceImpl class defines all the RolesService interface methods.
 * All the methods in this class will be invoked by the controller class
 * for accepting the request and giving the response.
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

@Service
public class RolesServiceImpl implements RolesService{
	
	String qry;
	
	@Autowired
	private DaoRoles daoRoles;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ApiPermission userRolesAccess;

	
	/**
	 * The function getAllRolesDetails fetches all roles details from the database.
	 */
	@Override
	public ResponseEntity<List<Roles>> getAllRolesDetails() {
		
		if(userRolesAccess.permission("getAllRolesDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		List<Roles> datalist = daoRoles.findAll();
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

	/**
	 * The function getRolesDetails fetches particular role details from the database.
	 */
	@Override
	public ResponseEntity<Object> getRolesDetails(int role_id) {
		
		if(userRolesAccess.permission("getRolesDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select * from roles where role_id = " + role_id + ";";
		
		List<Map<String, Object>> roles_details = jdbcTemplate.queryForList(qry);
		
		if(roles_details.isEmpty() == true) {

			throw new ResourceNotFoundException("User not found");
		}
		return new ResponseEntity<>(roles_details.get(0), HttpStatus.OK);
		
	}

	/**
	 * The function addRolesDetails adds new role in the database.
	 */
	@Override
	public ResponseEntity<Roles> addRolesDetails(Roles roles) {
		
		if(userRolesAccess.permission("addRolesDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		daoRoles.save(roles);
		return new ResponseEntity<>(roles,HttpStatus.OK);
		
	}

	/**
	 * The function deleteRolesDetails deletes the role from the database.
	 */
	@Override
	public ResponseEntity<String> deleteRolesDetails(int role_id) {

		if(userRolesAccess.permission("deleteRolesDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		qry = "Delete from roles where role_id = " + role_id +";"; 
		jdbcTemplate.execute(qry);
		return new ResponseEntity<>("Role Deleted!",HttpStatus.OK);
		
	}

}
