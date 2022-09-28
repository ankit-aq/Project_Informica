package com.airlinq.Project_Informica.service.product_service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.entities.Products;

/**
 * This ProductDetailsService interface declares all the required function needed in ProductDetailsServiceImpl class.
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 *
 */

@Service
public interface ProductDetailsService {

	public ResponseEntity<List<Products>> getAllProductDetails();
	
	public ResponseEntity<Object> getProductDetails(int product_Id);
	
	public ResponseEntity<Products> addProductDetails(Products productDetails);
	
	public ResponseEntity<String> deleteProductDetails(int productId);
	
}
