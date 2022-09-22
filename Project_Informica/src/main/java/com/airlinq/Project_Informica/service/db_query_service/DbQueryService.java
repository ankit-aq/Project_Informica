package com.airlinq.Project_Informica.service.db_query_service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;


/**
 * This QueryService interface declares all the required function needed in QueryServiceImpl class.
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

@Service
public interface DbQueryService {
	
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception;
	
	public ResponseEntity<Object>supplier_products();
	
	public ResponseEntity<Object>category_products_price();
	
	public ResponseEntity<Object>all_orders_details();
	
	public ResponseEntity<Object>particular_customer_order_details();

	public ResponseEntity<Object>supplier_products_in_a_row();
	
	public ResponseEntity<Object>total_price_function();
	
	public ResponseEntity<Object>categories_table_trigger();

	public ResponseEntity<Object>vw_customers_order_view();
	
	public ResponseEntity<Object>stored_procedure_for_all_customer();
	
	public ResponseEntity<Object>stored_procedure_for_particular_customer();

	public ResponseEntity<Object>stored_procedure_with_loop();
	
}
