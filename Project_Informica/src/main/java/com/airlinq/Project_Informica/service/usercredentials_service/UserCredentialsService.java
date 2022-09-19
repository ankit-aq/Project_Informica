package com.airlinq.Project_Informica.service.usercredentials_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.config.JwtAuthenticationEntryPoint;
import com.airlinq.Project_Informica.exception.UnauthorizedAccessException;

import net.bytebuddy.implementation.bytecode.Throw;

/**
 * This UserService class checks the credentials in the database and return the response.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

@Service
public class UserCredentialsService implements UserDetailsService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	
	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	
	String Qry;
	String dbusername;
	String dbpassword;

	/**
	 * This loadUserByUsername function checks if the data is present in the
	 * database using the sql query, if present it sends the user details and if not present
	 * returns the exception.
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UnauthorizedAccessException {
		
		
		Qry = "Select user_email, password from user_details where user_email = \"" + username + "\";";
		
		try {
			
			List<Map<String, Object>> ans = jdbcTemplate.queryForList(Qry);
			
			dbusername = ans.get(0).get("user_email").toString();
			dbpassword = ans.get(0).get("password").toString();
			
			
			if(dbusername != null) {
		
				return new User(dbusername, dbpassword, new ArrayList<>());
			}
			else {
				
				throw new UnauthorizedAccessException("User not found");
			}
			
		}
		catch (Exception e) {

			throw new UnauthorizedAccessException("User not found !!");
		}
		
		
		
		
		
	}

}
