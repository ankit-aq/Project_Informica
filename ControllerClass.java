package com.airlinq.Project_Informica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ControllerClass {

	//Variable to store query
	String Qry;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//API for 1st question of db assignment
	@GetMapping(path="/1")
	public ResponseEntity<Object>query1(){
		Qry = "Select Products.ProductID, Suppliers.SupplierId, Suppliers.ContactName, "
				+ "Products.ProductName, Products.UnitPrice from Products, Suppliers "
				+ "where Products.SupplierID = Suppliers.SupplierID "
				+ "order by Products.UnitPrice Asc;";

	
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	//API for 2nd question of db assignment
	@GetMapping(path="/2")
	public ResponseEntity<Object>query2(){
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
	
	//API for 3rd question of db assignment
	@GetMapping(path="/3")
	public ResponseEntity<Object>query3(){
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
	//API for 6th question of db assignment
	@GetMapping(path="/6")
	public ResponseEntity<Object>query6(){
		Qry = "Select Orders.OrderID, totalSum(Orders.OrderID)" 
				 + "from Orders order by Orders.OrderID";
		
		
		Object ans = jdbcTemplate.queryForList(Qry);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	//API for 6th question of db assignment
		@GetMapping(path="/7")
		public ResponseEntity<Object>query7(){
			Qry = "Select * from Products";
			
			
			Object ans = jdbcTemplate.queryForList(Qry);
			return new ResponseEntity<>(ans,HttpStatus.OK);
		}
		
		//API for 6th question of db assignment
				@GetMapping(path="/8")
				public ResponseEntity<Object>query8(){
					Qry = "Select * from vw_customers_order";
					
					
					Object ans = jdbcTemplate.queryForList(Qry);
					return new ResponseEntity<>(ans,HttpStatus.OK);
				}
		
	
	
	
	
}
