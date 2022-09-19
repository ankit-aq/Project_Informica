package com.airlinq.Project_Informica.service.db_query_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.airlinq.Project_Informica.exception.ResourceNotFoundException;
import com.airlinq.Project_Informica.exception.UnauthorizedAccessException;
import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;
import com.airlinq.Project_Informica.service.roles_service.UserRolesAccess;
import com.airlinq.Project_Informica.service.usercredentials_service.UserCredentialsService;
import com.airlinq.Project_Informica.utility.JwtUtility;

/**
 * The QueryServiceImpl class defines all the QueryService interface methods.
 * All the methods in this class will be invoked by the controller class
 * for accepting the request and giving the response.
 * 
 * @author Mahi Kumawat
 * @version 1.0
 *
 */

@Service
public class DbQueryServiceImpl implements DbQueryService{

	//Variable to store query
	String Qry;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserCredentialsService userCredentialsService;
	
	@Autowired
	private UserRolesAccess userRolesAccess;
	
	
	/**
	 * This authenticate function authenticate the requests and the credentials and return the token.
	 */
	
	@Override
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
		

		try {
			authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(
								jwtRequest.getUsername(), 
								jwtRequest.getPassword()
						)
			);
		}
		catch (BadCredentialsException e) {
			throw new UnauthorizedAccessException("Invalid_CREDENTIALS");
		}
		
		final UserDetails userDetails
				= userCredentialsService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token
				= jwtUtility.generateToken(userDetails);
		
		
		return new JwtResponse(token);
		
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> supplier_Products() {
		
		if(userRolesAccess.permission("supplier_Products") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select Products.ProductID, Suppliers.SupplierId, Suppliers.ContactName, "
				+ "Products.ProductName, Products.UnitPrice from Products, Suppliers "
				+ "where Products.SupplierID = Suppliers.SupplierID "
				+ "order by Products.UnitPrice Asc;";

	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
		
	}

	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */
	@Override
	public ResponseEntity<Object> category_Products_Price() {
		
		if(userRolesAccess.permission("category_Products_Price") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select categories.CategoryID ,"
				+ "	categories.CategoryName,"
				+ " Sum(products.UnitPrice) as TotalPrice "
				+ "from Categories as categories , Products as products "
				+ "where categories.CategoryID = products.CategoryID "
				+ "group by categories.CategoryID "
				+ "order by TotalPrice ASC;";

	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
		
	}

	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */
	
	@Override
	public ResponseEntity<Object> all_orders_details() {
		
		if(userRolesAccess.permission("all_orders_details") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select Orders.OrderID, Customers.CustomerID, "
				+ "Customers.CompanyName, Customers.ContactName, "
				+ "Orders.OrderDate, Orders.RequiredDate, "
				+ "Orders.ShippedDate, Orders.ShipVia, "
				+ "Orders.Freight, Orders.ShipName, "
				+ "Orders.ShipCity, Orders.ShipRegion, "
				+ "Orders.ShipPostalCode, Orders.ShipCountry "
				+ "from Orders inner join Customers "
				+ "on Customers.CustomerID = Orders.CustomerID "
				+ "order by Customers.CustomerID ASC;";

	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
		
	}

	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */
	
	@Override
	public ResponseEntity<Object> particular_customer_order_details() {
		
		if(userRolesAccess.permission("particular_customer_order_details") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "	Select c.OrderID,\r\n"
				+ "a.CompanyName,\r\n"
				+ "a.ContactName,\r\n"
				+ "d.ProductName,\r\n"
				+ "c.ProductID,\r\n"
				+ "c.UnitPrice,\r\n"
				+ "c.Quantity,\r\n"
				+ "c.Discount\r\n"
				+ "from Customers as a inner join Orders as b \r\n"
				+ "on a.CustomerID = b.CustomerID inner join `Order Details` as c \r\n"
				+ "on b.OrderID = c.OrderID inner join Products as d \r\n"
				+ "on c.ProductID = d.ProductID;";

		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
		
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> supplier_products_in_a_row() {
	
		if(userRolesAccess.permission("supplier_products_in_a_row") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry ="Select Suppliers.SupplierID,\r\n"
				+ "	Suppliers.CompanyName,\r\n"
				+ "    Suppliers.ContactName,\r\n"
				+ "    Group_Concat(Products.ProductName)\r\n"
				+ "from Suppliers right join Products\r\n"
				+ "on Suppliers.SupplierID = Products.SupplierId\r\n"
				+ "Group By Suppliers.SupplierID;";

	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> total_price_function() {
		
		if(userRolesAccess.permission("total_price_function") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select Orders.OrderID, totalSum(Orders.OrderID) \r\n"
				+ "from Orders order by Orders.OrderID";
		
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> categories_table_trigger() {
		
		if(userRolesAccess.permission("categories_table_trigger") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		 Qry = "Select * from Products";
		
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> vw_customers_order_view() {
		
		if(userRolesAccess.permission("vw_customers_order_view") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select * from vw_customers_order";

		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> stored_procedure_for_all_customer() {
		
		if(userRolesAccess.permission("stored_procedure_for_all_customer") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select * from CustomerOrder";
	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> stored_procedure_for_particular_customer() {
		
		if(userRolesAccess.permission("stored_procedure_for_particular_customer") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select * from CustomerDetails";
		
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */

	@Override
	public ResponseEntity<Object> stored_procedure_with_loop() {
		
		if(userRolesAccess.permission("stored_procedure_with_loop") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		Qry = "Select * from AllOrders;" ;
	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
}
