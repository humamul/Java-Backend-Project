package com.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.CustomerException;
import com.shopping.model.Address;
import com.shopping.model.Customer;
import com.shopping.model.Product;
import com.shopping.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerService cs;
	
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createAccount(@Valid @RequestBody Customer cus) throws CustomerException{
	Customer adm = cs.createAccount(cus);
		
		return new ResponseEntity<Customer>(adm,HttpStatus.OK);
	} 
	
	@PutMapping("/addAddress")
	public ResponseEntity<Address> putAddress(@RequestBody Address a,@RequestParam Integer i)throws CustomerException{
		
		
           Address	ad=	cs.setTheAddress(a, i);
		
		
		return new ResponseEntity<>(ad,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Customer> deleteAccount(@RequestParam String email,@RequestParam String password) throws CustomerException{
		Customer adm = cs.deleteAccont(email,password);
			
			return new ResponseEntity<Customer>(adm,HttpStatus.OK);
		} 
	
	@PutMapping("/cart/add")
	public ResponseEntity<String> addProductToCart(@RequestParam Integer productId,@RequestParam Integer customerId) throws CustomerException{
	String x =	cs.addProduct(productId,customerId);
		return new ResponseEntity<String>(x,HttpStatus.OK);
	}
	
	@GetMapping("/cart/show")
	public ResponseEntity<List<Product>> showCart(@RequestParam Integer customerId) throws CustomerException{
	List<Product> x = cs.getCart(customerId);	
	return new ResponseEntity<List<Product>>(x,HttpStatus.OK);
	}
	
	@DeleteMapping("/cart/remove/{ProductId}")
	public ResponseEntity<Product> removeFromCart(@RequestParam Integer cusId,@PathVariable Integer ProductId) throws CustomerException{
		
		Product s = cs.removeFromCart(cusId, ProductId);
		return new ResponseEntity<Product>(s,HttpStatus.OK);
		
	}
	
}
