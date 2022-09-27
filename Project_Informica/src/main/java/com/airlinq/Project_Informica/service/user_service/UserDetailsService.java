package com.airlinq.Project_Informica.service.user_service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.entities.User_Details;

/**
 * This UserDetailsService interface declares all the required function needed in UserDetailsServiceImpl class.
 * 
 * @author Mahi Kumawat
 * @version 1.0
 *
 */

@Service
public interface UserDetailsService {

	public ResponseEntity<List<User_Details>> getAllUserDetails();
	
	public ResponseEntity<Object> getUserDetails(int user_id);
	
	public ResponseEntity<User_Details> addUserDetails(User_Details User_Details);
	
	public ResponseEntity<String> deleteUserDetails(int user_id);
}
