package com.airlinq.Project_Informica.service.roles_api_mapping;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.airlinq.Project_Informica.entities.RolesAPIMapping;

public interface RolesAPIMappingDetailsService {

	public ResponseEntity<List<RolesAPIMapping>> getAllRolesAPIMappingDetails();
	
	public ResponseEntity<Object> getRolesAPIMappingDetails(int roles_api_mapping_id);
	
	public ResponseEntity<RolesAPIMapping> addRolesAPIMappingDetails(RolesAPIMapping rolesAPIMapping);
	
	public ResponseEntity<String> deleteRolesAPIMappingDetails(int roles_api_mapping_id);
	
	
}
