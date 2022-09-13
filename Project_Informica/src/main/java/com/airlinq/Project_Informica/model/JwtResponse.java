package com.airlinq.Project_Informica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
