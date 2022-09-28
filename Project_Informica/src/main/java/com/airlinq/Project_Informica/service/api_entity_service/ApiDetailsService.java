package com.airlinq.Project_Informica.service.api_entity_service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.entities.API;

@Service
public interface ApiDetailsService {


	public ResponseEntity<List<API>> getAllAPIDetails();
	
	public ResponseEntity<Object> getAPIDetails(int api_id);
	
	public ResponseEntity<API> addAPIDetails(API apis);
	
	public ResponseEntity<String> deleteAPIDetails(int api_id);
	
}
