package com.shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.CustomerException;
import com.shopping.model.Address;
import com.shopping.model.Cart;
import com.shopping.model.Customer;
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
	
	@PutMapping("addToCart")
	public ResponseEntity<String> addProductToCart(@RequestParam Integer productId,@RequestParam Integer customerId) throws CustomerException{
	String x =	cs.addProduct(productId,customerId);
		return new ResponseEntity<>(x,HttpStatus.OK);
	}
	
}
