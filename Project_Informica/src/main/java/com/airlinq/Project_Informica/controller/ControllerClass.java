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

/**
 * This controller class accepts all the http requests and send the response.
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 */

@RestController
public class ControllerClass {

	
	@Autowired
	private QueryServiceImpl queryServiceImpl;
	
	/**
	 * API for token creation
	 * 
	 * @param jwtRequest
	 * @throws Exception
	 */
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		return this.queryServiceImpl.authenticate(jwtRequest);
	}
	
	
	
	/**
	 * API for 1st question of db assignment
	 * 
	 */
	@GetMapping(path="/query1")
	public ResponseEntity<Object>query1(){
		
		return this.queryServiceImpl.query1();
	}
	
	/**
	 * API for 2nd question of db assignment
	 * 
	 */
	@GetMapping(path="/query2")
	public ResponseEntity<Object>query2(){
		
		return this.queryServiceImpl.query2();
	}
	
	/**
	 * API for 3rd question of db assignment
	 * 
	 */
	@GetMapping(path="/query3")
	public ResponseEntity<Object>query3(){
		
		return this.queryServiceImpl.query3();
	}
	
	/**
	 * API for 4th question of db assignment
	 * 
	 */
	@GetMapping(path="/query4")
	public ResponseEntity<Object>query4(){
			
		return this.queryServiceImpl.query4();
	}
	

	/**
	 * API for 5th question of db assignment
	 * 
	 */
	@GetMapping(path="/query5")
	public ResponseEntity<Object>query5(){
			
		return this.queryServiceImpl.query5();
	}
	
	/**
	 * API for 6th question of db assignment
	 * 
	 */
	@GetMapping(path="/query6")
	public ResponseEntity<Object>query6(){
				
		return this.queryServiceImpl.query6();
	}
		
	/**
	 * API for 7th question of db assignment
	 * 
	 */
	@GetMapping(path="/query7")
	public ResponseEntity<Object>query7(){
				
		return this.queryServiceImpl.query7();
	}
	
	/**
	 * API for 8th question of db assignment
	 * 
	 */
	@GetMapping(path="/query8")
	public ResponseEntity<Object>query8(){
				
		return this.queryServiceImpl.query8();
	}
	
	/**
	 * API for 9th question of db assignment
	 * 
	 */
	@GetMapping(path="/query9")
	public ResponseEntity<Object>query9(){
				
		return this.queryServiceImpl.query9();
	}
		
	/**
	 * API for 10th question of db assignment
	 * 
	 */
	@GetMapping(path="/query10")
	public ResponseEntity<Object>query10(){
				
		return this.queryServiceImpl.query10();
	}
	
	/**
	 * API for 11th question of db assignment
	 * 
	 */
	@GetMapping(path="/query11")
	public ResponseEntity<Object>query11(){
					
		return this.queryServiceImpl.query11();
	}
}
