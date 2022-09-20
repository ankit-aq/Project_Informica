package com.airlinq.Project_Informica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airlinq.Project_Informica.entities.Products;
import com.airlinq.Project_Informica.service.product_service.ProductDetailsServiceImpl;

/**
 * This ProductDetailsController class is a controller class for Products entity class.
 * This controller class accepts all the HTTP requests for products table and send the response.  
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 *
 */

@RestController
public class ProductDetailsController {

	@Autowired
	private ProductDetailsServiceImpl productDetailsServiceImpl;
	
	
	/**
	 * API for getting all the products details.
	 * 
	 */
	@GetMapping(path="/getAllProductDetails")
	public ResponseEntity<List<Products>> getAllProductDetails(){
		
		return this.productDetailsServiceImpl.getAllProductDetails();
	}
	
	/**
	 * API for fetching the product details by user_email.
	 * 
	 */
	
	@GetMapping(path="/getProductDetails/{productId}")
	public ResponseEntity<Products> getProductDetails(@PathVariable String productId) {
		
		return this.productDetailsServiceImpl.getProductDetails(productId);
	}
	
	/**
	 * API for inserting product details in the products table in the database.
	 * 
	 */
	
	@PostMapping(path="/addProductDetails")
	public ResponseEntity<Products> addProductDetails(@RequestBody Products productDetail) {
		
		return this.productDetailsServiceImpl.addProductDetails(productDetail);
	}
	
	/**
	 * API for deleting product details in the products table in the database using productId.
	 * 
	 */
	
	@DeleteMapping(path="/deleteProductDetails/{productId}")
    public ResponseEntity<String> deleteProductDetails(@PathVariable String productId) {

		return this.productDetailsServiceImpl.deleteProductDetails(productId);
    }
	
}
