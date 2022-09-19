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

@RestController
public class ProductDetailsController {

	@Autowired
	private ProductDetailsServiceImpl productDetailsServiceImpl;
	
	@GetMapping(path="/getAllProductDetails")
	public ResponseEntity<List<Products>> getAllProductDetails(){
		
		return this.productDetailsServiceImpl.getAllProductDetails();
	}
	
	@GetMapping(path="/getProductDetails/{productId}")
	public ResponseEntity<Products> getProductDetails(@PathVariable String productId) {
		
		return this.productDetailsServiceImpl.getProductDetails(productId);
	}
	
	@PostMapping(path="/addProductDetails")
	public ResponseEntity<Products> addProductDetails(@RequestBody Products productDetail) {
		
		return this.productDetailsServiceImpl.addProductDetails(productDetail);
	}
	
	@DeleteMapping(path="/deleteProductDetails/{productId}")
    public ResponseEntity<String> deleteProductDetails(@PathVariable String productId) {

		return this.productDetailsServiceImpl.deleteProductDetails(productId);
    }
	
}
