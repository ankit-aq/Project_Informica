package com.airlinq.Project_Informica.service.product_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.airlinq.Project_Informica.dao.DaoProduct;
import com.airlinq.Project_Informica.entities.Products;
import com.airlinq.Project_Informica.exception.ResourceNotFoundException;
import com.airlinq.Project_Informica.service.roles_service.UserRolesAccess;

/**
 * The ProductDetailsServiceImpl class defines all the ProductDetailsService interface methods.
 * All the methods in this class will be invoked by the controller class
 * for accepting the request and giving the response.
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 *
 */

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService{
	
	String qry;
	
	@Autowired
	private DaoProduct daoProduct;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRolesAccess userRolesAccess;
	
	/**
	 * The function getAllProductDetails fetches all products details from the database.
	 */

	@Override
	public ResponseEntity<List<Products>> getAllProductDetails() {
		
		if(userRolesAccess.permission("getAllProductDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}

		List<Products> datalist = daoProduct.findAll();
		return new ResponseEntity<>(datalist, HttpStatus.OK);
	}

	
	/**
	 * The function getProductDetail fetches particular product details from the database.
	 */
	@Override
	public ResponseEntity<Products> getProductDetails(String product_Id) {
		
		if(userRolesAccess.permission("getProductDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		Products productData = daoProduct.findById(Integer.parseInt(product_Id)).get();
		return new ResponseEntity<>(productData, HttpStatus.OK);
	}

	/**
	 * The function addProductDetail adds new product in the database.
	 */
	
	@Override
	public ResponseEntity<Products> addProductDetails(Products productDetails) {
		
		if(userRolesAccess.permission("addProductDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		daoProduct.save(productDetails);
		return new ResponseEntity<>(productDetails, HttpStatus.OK);
	}

	
	/**
	 * The function deleteProductDetail deletes the product from the database.
	 */
	@Override
	public ResponseEntity<String> deleteProductDetails(String productId) {
		
		if(userRolesAccess.permission("deleteProductDetails") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		qry = "Delete from products where productid = " + Integer.parseInt(productId) +";"; 
		jdbcTemplate.execute(qry);
		return new ResponseEntity<>("User Deleted!",HttpStatus.OK);
	}

}
