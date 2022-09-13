package com.airlinq.Project_Informica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;
import com.airlinq.Project_Informica.service.QueryServiceImpl;



@RestController
public class ControllerClass {

	
	@Autowired
	private QueryServiceImpl queryServiceImpl;
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		return this.queryServiceImpl.authenticate(jwtRequest);
	}
	
	
	
	//API for 1st question of db assignment
	@GetMapping(path="/query1")
	public ResponseEntity<Object>query1(){
		
		return this.queryServiceImpl.query1();
	}
	
	//API for 2nd question of db assignment
	@GetMapping(path="/query2")
	public ResponseEntity<Object>query2(){
		
		return this.queryServiceImpl.query2();
	}
	
	//API for 3rd question of db assignment
	@GetMapping(path="/query3")
	public ResponseEntity<Object>query3(){
		
		return this.queryServiceImpl.query3();
	}
	
}
