package com.airlinq.Project_Informica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The JwtRequest class contains username and password which
 * come from the request body.
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

	private String username;
	private String password;
	private String roleName;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRoleName() {
		return roleName;
	}
	
	
	
	
}
