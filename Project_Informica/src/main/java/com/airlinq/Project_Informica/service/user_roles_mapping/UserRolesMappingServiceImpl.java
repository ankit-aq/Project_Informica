package com.airlinq.Project_Informica.service.user_roles_mapping;

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
	public ResponseEntity<List<UserRolesMapping>> getAllUserRolesMappingDetails() {
		
		System.out.println("hhh");
		if(userRolesAccess.permission("getAllUserRolesMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		datalist = daoUserRolesMapping.findAll();
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

	
	/**
	 * The function getUserRolesMappingDetails fetches particular mapping details from the database.
	 */
	@Override
	public ResponseEntity<Object> getUserRolesMappingDetails(int roles_api_mapping_id) {
		
		
		if(userRolesAccess.permission("getUserRolesMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select * from roles_api_mapping where roles_api_mapping_id = " + roles_api_mapping_id + ";";
		
		List<Map<String, Object>> mapping_details = jdbcTemplate.queryForList(qry);
		
		if(mapping_details.isEmpty() == true) {

			throw new ResourceNotFoundException("User not found");
		}
		return new ResponseEntity<>(mapping_details.get(0), HttpStatus.OK);
	}

	
	/**
	 * The function addUserRolesMappingDetails adds new user_roles_mapping data in the database.
	 */
	@Override
	public ResponseEntity<UserRolesMapping> addUserRolesMappingDetails(UserRolesMapping UserRolesMapping) {
		
		if(userRolesAccess.permission("addUserRolesMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		daoUserRolesMapping.save(UserRolesMapping);
		return new ResponseEntity<>(UserRolesMapping,HttpStatus.OK);
		
	}

	
	/**
	 * The function deleteUserRolesMappingDetails deletes the role_api_mapping data from the database.
	 */
	@Override
	public ResponseEntity<String> deleteUserRolesMappingDetails(int roles_api_mapping_id) {
		
		
		if(userRolesAccess.permission("deleteUserRolesMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		qry = "Delete from roles_api_mapping where roles_api_mapping_id = " + roles_api_mapping_id +";"; 
		jdbcTemplate.execute(qry);
		return new ResponseEntity<>("Data Deleted!",HttpStatus.OK);
	}

}
