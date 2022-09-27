package com.airlinq.Project_Informica.service.user_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.airlinq.Project_Informica.dao.DaoUser;
import com.airlinq.Project_Informica.entities.User_Details;
import com.airlinq.Project_Informica.exception.ResourceNotFoundException;
import com.airlinq.Project_Informica.service.roles_service.UserRolesAccess;


/**
 * The UserDetailsServiceImpl class defines all the UserDetailsService interface methods.
 * All the methods in this class will be invoked by the UserDetailsController class
 * for accepting the request and giving the response.
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	String qry;
	
	@Autowired
	private DaoUser daouser;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRolesAccess userRolesAccess;
	
	/**
	 * The function getAllUserDetails fetches all user details from the database.
	 */
	@Override
	public ResponseEntity<List<User_Details>> getAllUserDetails() {
		
		if(userRolesAccess.permission("getAllUserDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		List<User_Details> datalist = daouser.findAll();
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

	
	/**
	 * The function getUserDetail fetches particular user details from the database.
	 */
	@Override
	public ResponseEntity<Object> getUserDetails(int user_id) {
		
		if(userRolesAccess.permission("getUserDetail") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select * from user_details where id = " + user_id+ ";";
		
		List<Map<String, Object>> user_details = jdbcTemplate.queryForList(qry);
		
		if(user_details.isEmpty() == true) {

			throw new ResourceNotFoundException("User not found");
		}
		return new ResponseEntity<>(user_details.get(0) ,HttpStatus.OK);
		
	}

	
	/**
	 * The function addUserDetail adds new user in the database.
	 */
	@Override
	public ResponseEntity<User_Details> addUserDetails(User_Details userdetails) {
		
		if(userRolesAccess.permission("addUserDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		daouser.save(userdetails);
		return new ResponseEntity<>(userdetails,HttpStatus.OK);
	}


	/**
	 * The function deleteUserDetail deletes the user from the database.
	 */
	@Override
	public ResponseEntity<String> deleteUserDetails(int user_id) {
		
		if(userRolesAccess.permission("deleteUserDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Delete from user_details where id = " + user_id +";"; 
		jdbcTemplate.execute(qry);
		return new ResponseEntity<>("User Deleted!",HttpStatus.OK);
	}
	
	
	
	
	
}
