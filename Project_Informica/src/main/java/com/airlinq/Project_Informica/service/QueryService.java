package com.airlinq.Project_Informica.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;

@Service
public interface QueryService {
	
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception;
	
	public ResponseEntity<Object>query1();
	
	public ResponseEntity<Object>query2();
	
	public ResponseEntity<Object>query3();
	
	public ResponseEntity<Object>query4();

	public ResponseEntity<Object>query5();
	
	public ResponseEntity<Object>query6();
	
	public ResponseEntity<Object>query7();

	public ResponseEntity<Object>query8();
	
	public ResponseEntity<Object>query9();
	
	public ResponseEntity<Object>query10();

	public ResponseEntity<Object>query11();
	
	
}
