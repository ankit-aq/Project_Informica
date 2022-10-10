package com.airlinq.Project_Informica.service.user_roles_mapping_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.dao.DaoUserRolesMapping;
import com.airlinq.Project_Informica.entities.UserRolesMapping;
import com.airlinq.Project_Informica.exception.ResourceNotFoundException;
import com.airlinq.Project_Informica.service.api_permission.ApiPermission;

@Service
public class UserRolesMappingServiceImpl implements UserRolesMappingService{

	/**
	 * Variable to store the query.
	 */
	String qry;
	
	/**
	 * list to store UserRolesMapping data items.
	 */
	List<UserRolesMapping> datalist;
	
	@Autowired
	private DaoUserRolesMapping daoUserRolesMapping;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ApiPermission userRolesAccess;
	
	
	/**
	 * The function getAllUserRolesMappingDetails fetches all mapping details from the database.
	 */
	@Override
	public ResponseEntity<Object> getAllUserRolesMappingDetails() {
		
		if(userRolesAccess.permission("getAllUserRolesMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select * from user_roles_mapping;";
		
		List<Map<String, Object>> datalist = jdbcTemplate.queryForList(qry);
		
		if(datalist.isEmpty() == true) {

			throw new ResourceNotFoundException("User not found");
		}
		
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

	
	/**
	 * The function getUserRolesMappingDetails fetches particular mapping details from the database.
	 */
	@Override
	public ResponseEntity<Object> getUserRolesMappingDetails(int user_roles_mapping_id) {
		
		
		if(userRolesAccess.permission("getUserRolesMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select * from user_roles_mapping where user_roles_mapping_id = " + user_roles_mapping_id + ";";
		
		List<Map<String, Object>> mapping_details = jdbcTemplate.queryForList(qry);
		
		if(mapping_details.isEmpty() == true) {

			throw new ResourceNotFoundException("User not found");
		}
		return new ResponseEntity<>(mapping_details.get(0), HttpStatus.OK);
	}


	
	/**
	 * The function deleteUserRolesMappingDetails deletes the role_api_mapping data from the database.
	 */
	@Override
	public ResponseEntity<String> deleteUserRolesMappingDetails(int user_roles_mapping_id) {
		
		
		if(userRolesAccess.permission("deleteUserRolesMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		daoUserRolesMapping.deleteById(user_roles_mapping_id);
		return new ResponseEntity<>("Data Deleted!",HttpStatus.OK);
	}

}
