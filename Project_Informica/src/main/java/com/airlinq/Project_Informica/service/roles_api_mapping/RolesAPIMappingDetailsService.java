package com.airlinq.Project_Informica.service.roles_api_mapping;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.entities.RolesAPIMapping;

/**
 * This RolesAPIMappingDetailsService interface declares all the required function needed in RolesAPIMappingDetailsService class.
 * 
 * @author  Mahi Kumawat
 * @version 1.0
 *
 */

@Service
public interface RolesAPIMappingDetailsService {

	public ResponseEntity<Object> getAllRolesAPIMappingDetails();
	
	public ResponseEntity<Object> getRolesAPIMappingDetails(int roles_api_mapping_id);
	
	public ResponseEntity<String> deleteRolesAPIMappingDetails(int roles_api_mapping_id);
	
	
}
