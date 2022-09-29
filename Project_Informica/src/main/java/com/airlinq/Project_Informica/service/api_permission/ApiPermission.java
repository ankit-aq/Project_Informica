package com.airlinq.Project_Informica.service.api_permission;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.utility.JwtUtility;

/**
 * This UserRolesAccess class defines permission method where it check if the user have access
 * to the API.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */
@Service
public class ApiPermission {
	
	String token;
	String authorization;
	String user_email;
	String role_name;
	String qry;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * The method checks if the user has access to the API.
	 * It returns false if the user has not access to the API.
	 * 
	 * @param queryName
	 * @return boolean value
	 */
	public boolean permission(String queryName) {
		authorization = httpServletRequest.getHeader("Authorization");
	    token = null;
	    user_email = null;
	     
	    if(authorization != null){
	    	token = authorization;
	        user_email = jwtUtility.getUsernameFromToken(token);
	        role_name = jwtUtility.getPasswordFromToken(token);
	    }
	     
	    qry = "Select email, password, role_name from user_details inner join user_roles_mapping on user_details.user_id = user_roles_mapping.user_id "
				+ "inner join roles on user_roles_mapping.role_id = roles.role_id where email = \"" + user_email + "\" and role_name = \"" + role_name + "\";";
			
	    List<Map<String, Object>> user_details = jdbcTemplate.queryForList(qry);
	     
	    if(user_details.get(0).get("role_name").toString().equals("admin")) {
	    	return true;
	    }
	    else {
	    	 
	    	qry = "Select api_name from user_details inner join user_roles_mapping on user_details.user_id = user_roles_mapping.user_id "
	    			+ "inner join roles on user_roles_mapping.role_id = roles.role_id"
	    			+ "inner join roles_api_mapping on roles.role_id = roles_api_mapping.role_id "
	    			+ "inner join api on roles_api_mapping.api_id = api.api_id "
	    			+ "where email = \"" + user_email + "\" and role_name = \"" + role_name + "\"and api_name = \"" + queryName + "\";";
	    	
				
		    List<Map<String, Object>> query_details = jdbcTemplate.queryForList(qry);
		    

		    if(query_details.isEmpty() == true) {
		    	return false;
		    }
	    	 
	    }
	     
	    return true;
		
	}
	
}
