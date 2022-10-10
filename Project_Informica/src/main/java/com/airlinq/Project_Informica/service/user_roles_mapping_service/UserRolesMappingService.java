package com.airlinq.Project_Informica.service.user_roles_mapping_service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.entities.UserRolesMapping;


/**
 * This UserRolesMappingService interface declares all the required function needed in UserRolesMappingServiceImpl class.
 * 
 * @author  Ankit Sharma
 * @version 1.0
 *
 */
@Service
public interface UserRolesMappingService {

	public ResponseEntity<Object> getAllUserRolesMappingDetails();
	
	public ResponseEntity<Object> getUserRolesMappingDetails(int user_roles_mapping_id);
	
	public ResponseEntity<String> deleteUserRolesMappingDetails(int user_roles_mapping_id);
	
}
