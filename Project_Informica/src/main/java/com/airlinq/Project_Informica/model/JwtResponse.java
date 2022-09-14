package com.airlinq.Project_Informica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This JwtResponse class stores the token and return it.
 * 
 * @author Mahi kumawat
 * @version 1.0
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	
	private String jwtToken;
	
	public JwtResponse(String token) {
		jwtToken = token;
	}

	public String getToken() {
		
		return jwtToken;
	}
}
