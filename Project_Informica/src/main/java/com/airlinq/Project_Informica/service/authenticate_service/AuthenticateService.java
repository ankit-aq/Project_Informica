package com.airlinq.Project_Informica.service.authenticate_service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;

@Service
public interface AuthenticateService {

	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception;
	
}
