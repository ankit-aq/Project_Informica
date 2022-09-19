package com.airlinq.Project_Informica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.airlinq.Project_Informica.entities.Role_Access;
import com.airlinq.Project_Informica.service.roles_service.RolesServiceImpl;


@RestController
public class RolesDetailsController {

	@Autowired
	private RolesServiceImpl rolesServiceImpl;
	
	@GetMapping(path="/getAllRolesDetails")
	public ResponseEntity<List<Role_Access>> getAllRolesDetails(){
		
		return this.rolesServiceImpl.getAllRolesDetails();
	}
	
	@GetMapping(path="/getRolesDetails/{user_email}")
	public ResponseEntity<Object> getRolesDetail(@PathVariable String user_email){
		return this.rolesServiceImpl.getRolesDetails(user_email.toString());
	}
	
	@PostMapping(path="/addRolesDetails")
	public ResponseEntity<Role_Access> addRolesDetails(@RequestBody Role_Access roleAccess){
		return this.rolesServiceImpl.addRolesDetails(roleAccess);
	}
	
	@DeleteMapping(path="/deleteRolesDetails/{role_id}")
    public ResponseEntity<String> deleteRolesDetails(@PathVariable String role_id) {

		return this.rolesServiceImpl.deleteRolesDetails(role_id);
    }
	
}
