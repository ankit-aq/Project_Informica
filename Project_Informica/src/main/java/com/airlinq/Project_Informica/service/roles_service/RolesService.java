package com.airlinq.Project_Informica.service.roles_service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.entities.Role_Access;

@Service
public interface RolesService {

	public ResponseEntity<List<Role_Access>> getAllRolesDetails();
	
	public ResponseEntity<Object> getRolesDetails(String user_email);
	
	public ResponseEntity<Role_Access> addRolesDetails(Role_Access roleAccess);
	
	public ResponseEntity<String> deleteRolesDetails(String role_id);
	
}
