package com.airlinq.Project_Informica.service.roles_api_mapping;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.airlinq.Project_Informica.dao.DaoRolesAPIMapping;
import com.airlinq.Project_Informica.entities.RolesAPIMapping;
import com.airlinq.Project_Informica.exception.ResourceNotFoundException;
import com.airlinq.Project_Informica.service.api_permission.ApiPermission;


/**
 * The RolesAPIMappingDetailsServiceImpl class defines all the RolesAPIMappingDetailsService interface methods.
 * All the methods in this class will be invoked by the controller class
 * for accepting the request and giving the response.
 * 
 * @author Mahi Kumawat
 * @version 1.0
 *
 */

@Service
public class RolesAPIMappingDetailsServiceImpl implements RolesAPIMappingDetailsService{

	/**
	 * Variable to store the query.
	 */
	String qry;
	
	/**
	 * list to store RolesAPIMapping data items.
	 */
	List<RolesAPIMapping> datalist;
	
	@Autowired
	private DaoRolesAPIMapping daoRolesAPIMapping;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ApiPermission userRolesAccess;
	
	
	/**
	 * The function getAllRolesAPIMappingDetails fetches all mapping details from the database.
	 */
	@Override
	public ResponseEntity<Object> getAllRolesAPIMappingDetails() {
		
		
		if(userRolesAccess.permission("getAllRolesAPIMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select * from roles_api_mapping;";
		
		List<Map<String, Object>> datalist = jdbcTemplate.queryForList(qry);
		
		if(datalist.isEmpty() == true) {

			throw new ResourceNotFoundException("User not found");
		}
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

	
	/**
	 * The function getRolesAPIMappingDetails fetches particular mapping details from the database.
	 */
	@Override
	public ResponseEntity<Object> getRolesAPIMappingDetails(int roles_api_mapping_id) {
		
		
		if(userRolesAccess.permission("getRolesAPIMappingDetails") != true) {
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
	 * The function deleteRolesAPIMappingDetails deletes the role_api_mapping data from the database.
	 */
	@Override
	public ResponseEntity<String> deleteRolesAPIMappingDetails(int roles_api_mapping_id) {
		
		
		if(userRolesAccess.permission("deleteRolesAPIMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		daoRolesAPIMapping.deleteById(roles_api_mapping_id);
		return new ResponseEntity<>("Data Deleted!",HttpStatus.OK);
	}

}
