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
		System.out.println("hello4");
		
		final String token
				= jwtUtility.generateToken(userDetails);
		
		System.out.println("hello5");
		
		return new JwtResponse(token);
		
	}

	@Override
	public ResponseEntity<Object> query1() {
		
		Qry = "Select Products.ProductID, Suppliers.SupplierId, Suppliers.ContactName, "
				+ "Products.ProductName, Products.UnitPrice from Products, Suppliers "
				+ "where Products.SupplierID = Suppliers.SupplierID "
				+ "order by Products.UnitPrice Asc;";

	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
		
	}

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

	@Override
	public ResponseEntity<Object> query4() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> query5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> query6() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> query7() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> query8() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> query9() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> query10() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> query11() {
		// TODO Auto-generated method stub
		return null;
	}

}
