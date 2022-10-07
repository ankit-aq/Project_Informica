package com.airlinq.Project_Informica.model;

import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty(notes = "username", example = "ankit@gmail.com", required = true) 
	private String username;
	
	@ApiModelProperty(notes = "password", example = "ankit", required = true) 
	private String password;
	
	@ApiModelProperty(notes = "roleName", example = "admin", required = true) 
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
