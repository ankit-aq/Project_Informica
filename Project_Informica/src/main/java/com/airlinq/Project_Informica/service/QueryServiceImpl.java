package com.airlinq.Project_Informica.service;

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

import com.airlinq.Project_Informica.model.JwtRequest;
import com.airlinq.Project_Informica.model.JwtResponse;
import com.airlinq.Project_Informica.utility.JwtUtility;

/**
 * The QueryServiceImpl class defines all the QueryService interface methods.
 * All the methods in this class will be invoked by the controller class
 * for accepting the request and giving the response.
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

@Service
public class QueryServiceImpl implements QueryService{

	//Variable to store query
	String Qry;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	
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
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		final UserDetails userDetails
				= userService.loadUserByUsername(jwtRequest.getUsername());
		
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
	public ResponseEntity<Object> query1() {
		
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
	public ResponseEntity<Object> query2() {
		
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
	public ResponseEntity<Object> query3() {
		
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
	public ResponseEntity<Object> query4() {
		
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
	public ResponseEntity<Object> query5() {
	
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
	public ResponseEntity<Object> query6() {
		
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
	public ResponseEntity<Object> query7() {
		
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
	public ResponseEntity<Object> query8() {
		
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
	public ResponseEntity<Object> query9() {
		
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
	public ResponseEntity<Object> query10() {
		
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
	public ResponseEntity<Object> query11() {
		
		Qry = "Select * from AllOrders;" ;
	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}

}
