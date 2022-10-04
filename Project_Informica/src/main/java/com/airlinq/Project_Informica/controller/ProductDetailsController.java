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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	
	@ApiOperation(value = "Fetch all product details")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	@GetMapping(path="/getAllProductDetails")
	public ResponseEntity<List<Products>> getAllProductDetails(){
		
		return this.productDetailsServiceImpl.getAllProductDetails();
	}
	
	/**
	 * API for fetching the product details by user_email.
	 * 
	 */
	
	@GetMapping(path="/getProductDetails/{productId}")
	@ApiOperation(value = "Fetch product details by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved")	
	})
	public ResponseEntity<Object> getProductDetails(@PathVariable @ApiParam(name = "productId", value = "Product id", example = "1") int productId) {
		
		return this.productDetailsServiceImpl.getProductDetails(productId);
	}
	
	/**
	 * API for inserting product details in the products table in the database.
	 * 
	 */
	
	@PostMapping(path="/addProductDetails")
	@ApiOperation(value = "Add product details in the database")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully added")	
	})
	public ResponseEntity<Products> addProductDetails(@RequestBody @ApiParam(name = "Request Body", value = "Request Params") Products productDetail) {
		
		return this.productDetailsServiceImpl.addProductDetails(productDetail);
	}
	
	/**
	 * API for deleting product details in the products table in the database using productId.
	 * 
	 */
	
	@DeleteMapping(path="/deleteProductDetails/{productId}")
	@ApiOperation(value = "delete a product by id")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully deleted")	
	})
    public ResponseEntity<String> deleteProductDetails(@PathVariable @ApiParam(name = "productId", value = "Product id", example = "1") int productId) {

		return this.productDetailsServiceImpl.deleteProductDetails(productId);
    }
	
}
