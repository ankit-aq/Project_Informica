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
import com.airlinq.Project_Informica.service.roles_service.UserRolesAccess;

@Service
public class RolesAPIMappingDetailsServiceImpl implements RolesAPIMappingDetailsService{

	String qry;
	
	List<RolesAPIMapping> datalist;
	
	@Autowired
	private DaoRolesAPIMapping daoRolesAPIMapping;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRolesAccess userRolesAccess;
	
	@Override
	public ResponseEntity<List<RolesAPIMapping>> getAllRolesAPIMappingDetails() {
		
		
		if(userRolesAccess.permission("getAllRolesAPIMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		datalist = daoRolesAPIMapping.findAll();
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

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

	@Override
	public ResponseEntity<RolesAPIMapping> addRolesAPIMappingDetails(RolesAPIMapping rolesAPIMapping) {
		
		if(userRolesAccess.permission("addRolesAPIMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		daoRolesAPIMapping.save(rolesAPIMapping);
		return new ResponseEntity<>(rolesAPIMapping,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<String> deleteRolesAPIMappingDetails(int roles_api_mapping_id) {
		
		
		if(userRolesAccess.permission("deleteRolesAPIMappingDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		qry = "Delete from roles_api_mapping where roles_api_mapping_id = " + roles_api_mapping_id +";"; 
		jdbcTemplate.execute(qry);
		return new ResponseEntity<>("User Deleted!",HttpStatus.OK);
	}

}
