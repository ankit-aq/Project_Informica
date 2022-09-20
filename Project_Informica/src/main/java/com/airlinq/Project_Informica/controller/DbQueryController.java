package com.airlinq.Project_Informica.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;
import com.airlinq.Project_Informica.service.db_query_service.DbQueryServiceImpl;

/**
 * This controller class accepts all the http requests for the database queries of the database assignment and send the response.
 * 
 * @author Adarsh Kumar Jha
 * @version 1.0
 */

@RestController
public class DbQueryController {

	
	@Autowired
	private DbQueryServiceImpl dbQueryServiceImpl;
	
	/**
	 * API for token creation
	 * 
	 * @param jwtRequest
	 * @throws Exception
	 */
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		return this.dbQueryServiceImpl.authenticate(jwtRequest);
	}
	
	
	
	/**
	 * API for 1st question of db assignment
	 * 
	 */
	@GetMapping(path="/supplier_products")
	public ResponseEntity<Object>supplier_Products(){
		
		return this.dbQueryServiceImpl.supplier_Products();
	}
	
	/**
	 * API for 2nd question of db assignment
	 * 
	 */
	@GetMapping(path="/category_products_price")
	public ResponseEntity<Object>category_Products_Price(){
		
		return this.dbQueryServiceImpl.category_Products_Price();
	}
	
	/**
	 * API for 3rd question of db assignment
	 * 
	 */
	@GetMapping(path="/all_orders_details")
	public ResponseEntity<Object>all_orders_details(){
		
		return this.dbQueryServiceImpl.all_orders_details();
	}
	
	/**
	 * API for 4th question of db assignment
	 * 
	 */
	@GetMapping(path="/particular_customer_order_details")
	public ResponseEntity<Object>particular_customer_order_details(){
			
		return this.dbQueryServiceImpl.particular_customer_order_details();
	}
	

	/**
	 * API for 5th question of db assignment
	 * 
	 */
	@GetMapping(path="/supplier_products_in_a_row")
	public ResponseEntity<Object>supplier_products_in_a_row(){
			
		return this.dbQueryServiceImpl.supplier_products_in_a_row();
	}
	
	/**
	 * API for 6th question of db assignment
	 * 
	 */
	@GetMapping(path="/total_price_function")
	public ResponseEntity<Object>total_price_function(){
				
		return this.dbQueryServiceImpl.total_price_function();
	}
		
	/**
	 * API for 7th question of db assignment
	 * 
	 */
	@GetMapping(path="/categories_table_trigger")
	public ResponseEntity<Object>categories_table_trigger(){
				
		return this.dbQueryServiceImpl.categories_table_trigger();
	}
	
	/**
	 * API for 8th question of db assignment
	 * 
	 */
	@GetMapping(path="/vw_customers_order_view")
	public ResponseEntity<Object>vw_customers_order_view(){
				
		return this.dbQueryServiceImpl.vw_customers_order_view();
	}
	
	/**
	 * API for 9th question of db assignment
	 * 
	 */
	@GetMapping(path="/stored_procedure_for_all_customer")
	public ResponseEntity<Object>stored_procedure_for_all_customer(){
				
		return this.dbQueryServiceImpl.stored_procedure_for_all_customer();
	}
		
	/**
	 * API for 10th question of db assignment
	 * 
	 */
	@GetMapping(path="/stored_procedure_for_particular_customer")
	public ResponseEntity<Object>stored_procedure_for_particular_customer(){
				
		return this.dbQueryServiceImpl.stored_procedure_for_particular_customer();
	}
	
	/**
	 * API for 11th question of db assignment
	 * 
	 */
	@GetMapping(path="/stored_procedure_with_loop")
	public ResponseEntity<Object>stored_procedure_with_loop(){
					
		return this.dbQueryServiceImpl.stored_procedure_with_loop();
	}
	
	
}
