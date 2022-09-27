package com.airlinq.Project_Informica.service.db_query_service;


import java.util.List;
import java.util.Map;

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
	private String qry;
	
	private String userRoleName;
	
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
		
		userRoleName = userCredentialsService.usernameRole(jwtRequest.getUsername(), jwtRequest.getRoleName());
				
		final UserDetails userDetails
				= userCredentialsService.loadUserData(userRoleName);
		
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
	public ResponseEntity<Object> supplier_products() {
		
		if(userRolesAccess.permission("supplier_products") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select products.productid, Suppliers.supplierid, Suppliers.ContactName, "
				+ "products.product_name, products.unit_price from products, Suppliers "
				+ "where products.supplierid = Suppliers.supplierid "
				+ "order by products.unit_price Asc;";

	
		Object ans = jdbcTemplate.queryForList(qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
		
	}

	
	/**
	 * This function returns the data from the database after 
	 * filtering the data using the sql query.
	 * It returns the data in the json format.
	 * 
	 */
	@Override
	public ResponseEntity<Object> category_products_price() {
		
		if(userRolesAccess.permission("category_products_Price") != true) {
			throw new ResourceNotFoundException("You do not have permission for this API");
		}
		
		qry = "Select categories.categoryid ,"
				+ "	categories.CategoryName,"
				+ " Sum(products.unit_price) as TotalPrice "
				+ "from Categories as categories , products as products "
				+ "where categories.categoryid = products.categoryid "
				+ "group by categories.categoryid "
				+ "order by TotalPrice ASC;";

	
		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry = "Select Orders.OrderID, Customers.CustomerID, "
				+ "Customers.CompanyName, Customers.ContactName, "
				+ "Orders.OrderDate, Orders.RequiredDate, "
				+ "Orders.ShippedDate, Orders.ShipVia, "
				+ "Orders.Freight, Orders.ShipName, "
				+ "Orders.ShipCity, Orders.ShipRegion, "
				+ "Orders.ShipPostalCode, Orders.ShipCountry "
				+ "from Orders inner join Customers "
				+ "on Customers.CustomerID = Orders.CustomerID "
				+ "order by Customers.CustomerID ASC;";

	
		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry = "	Select c.OrderID,\r\n"
				+ "a.CompanyName,\r\n"
				+ "a.ContactName,\r\n"
				+ "d.product_name,\r\n"
				+ "c.productid,\r\n"
				+ "c.unit_price,\r\n"
				+ "c.Quantity,\r\n"
				+ "c.Discount\r\n"
				+ "from Customers as a inner join Orders as b \r\n"
				+ "on a.CustomerID = b.CustomerID inner join `Order Details` as c \r\n"
				+ "on b.OrderID = c.OrderID inner join products as d \r\n"
				+ "on c.productid = d.productid;";

		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry ="Select Suppliers.supplierid,\r\n"
				+ "	Suppliers.CompanyName,\r\n"
				+ "    Suppliers.ContactName,\r\n"
				+ "    Group_Concat(products.product_name)\r\n"
				+ "from Suppliers right join products\r\n"
				+ "on Suppliers.supplierid = products.supplierid\r\n"
				+ "Group By Suppliers.supplierid;";

	
		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry = "Select Orders.OrderID, totalSum(Orders.OrderID) \r\n"
				+ "from Orders order by Orders.OrderID";
		
		Object ans = jdbcTemplate.queryForList(qry);
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
		
		 qry = "Select * from products";
		
		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry = "Select * from vw_customers_order";

		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry = "Select * from CustomerOrder";
	
		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry = "Select * from CustomerDetails";
		
		Object ans = jdbcTemplate.queryForList(qry);
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
		
		qry = "Select * from AllOrders;" ;
	
		Object ans = jdbcTemplate.queryForList(qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
}
