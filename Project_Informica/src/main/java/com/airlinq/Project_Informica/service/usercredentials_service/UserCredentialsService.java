
package com.airlinq.Project_Informica.service.usercredentials_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.airlinq.Project_Informica.config.JwtAuthenticationEntryPoint;
import com.airlinq.Project_Informica.exception.UnauthorizedAccessException;


/**
 * This UserService class checks the credentials in the database and return the response.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

@Service
public class UserCredentialsService implements UserDetailsService {
	
	private String qry;
	private String dbusername;
	private String dbpassword;
	private String dbroleName;
	private String email;
	private String roleName;
	private String[] usernameRoleIdDetails;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	private JwtAuthenticationEntryPoint entryPoint;
	
	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	
	

	/**
	 * This loadUserByUsername function checks if the data is present in the
	 * database using the sql query, if present it sends the user details and if not present
	 * returns the exception.
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UnauthorizedAccessException {
		

		
		qry = "Select email, password from user_details where email = \"" + username + "\";";
		
		try {
			
			List<Map<String, Object>> ans = jdbcTemplate.queryForList(qry);
			
			dbusername = ans.get(0).get("email").toString();
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
	
	
	public UserDetails loadUserData(String userRoleData) {
		
		usernameRoleIdDetails = userRoleData.split(" ");
		email = usernameRoleIdDetails[0];
		roleName = usernameRoleIdDetails[1];
		
		
		qry = "Select email, password, role_name from user_details inner join roles on user_details.role_id = roles.role_id "
				+ "where email = \"" + email + "\" and role_name = \"" + roleName + "\";";
				
		
		try {
			
			List<Map<String, Object>> ans = jdbcTemplate.queryForList(qry);
			
			dbusername = ans.get(0).get("email").toString();
			dbpassword = ans.get(0).get("password").toString();
			dbroleName = ans.get(0).get("role_name").toString();
			
			
			if(dbusername != null) {

				return new User(dbusername, dbroleName, new ArrayList<>());
			}
			else {
				
				throw new UnauthorizedAccessException("User not found");
			}
			
		}
		catch (Exception e) {

			throw new UnauthorizedAccessException("User not found !!");
		}
		
		
	}
	
	public String usernameRole(String username, String role_name) {
		
		
		return username + " " + role_name;
	}
	
	

}