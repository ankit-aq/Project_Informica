package com.airlinq.Project_Informica.service.roles_service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.utility.JwtUtility;

@Service
public class UserRolesAccess {
	
	String token;
	String authorization;
	String user_email;
	String qry;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean permission(String queryName) {
		System.out.println("Wuff");
		authorization = httpServletRequest.getHeader("Authorization");
	    token = null;
	    user_email = null;
	     
	    if(authorization != null){
	    	token = authorization;
	        user_email = jwtUtility.getUsernameFromToken(token);
	    }
	     
	    qry = "Select * from user_details where user_email = \"" + user_email + "\";";
			
	    List<Map<String, Object>> user_details = jdbcTemplate.queryForList(qry);
	     
	    if(user_details.get(0).get("roles") == "admin") {
	    	return true;
	    }
	    else {
	    	 
	    	qry = "Select * from role_access where user_email = \"" + user_email + "\" and query_name = \"" + queryName + "\";";
				
		    List<Map<String, Object>> query_details = jdbcTemplate.queryForList(qry);

		    if(query_details.isEmpty() == true) {
		    	System.out.println("Finally2");
		    	return false;
		    }
	    	 
	    }
	     
	    return true;
		
	}
	
}
