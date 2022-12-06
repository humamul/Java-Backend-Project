package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.CustomerException;
import com.shopping.model.Orders;
import com.shopping.model.Product;
import com.shopping.service.OrderService;

@RestController
@RequestMapping(value = "/cus/order")
public class OrderController {

	@Autowired
	private OrderService os;
	
	
	@PutMapping("/buyNow")
	public ResponseEntity<Product> buyNow(@RequestParam Integer CusId,@RequestParam Integer sproId) throws CustomerException{
		
		Product x = os.buyNow(CusId, sproId);
		
		return new ResponseEntity<Product>(x,HttpStatus.OK);
	}
	
	@GetMapping("getAllOrders")
	public ResponseEntity<List<Orders>> getAll(@RequestParam Integer CusId) throws CustomerException{
		List<Orders> o = os.getAllOrders(CusId); 
		return new ResponseEntity<List<Orders>>(o,HttpStatus.OK); 
	}
	
	@PutMapping("orderCartProduct")
	public ResponseEntity<List<Product>> orderAll(@RequestParam Integer CusId) throws CustomerException{
		List<Product> o = os.orderAllCartProducts(CusId) ;
		return new ResponseEntity<List<Product>>(o,HttpStatus.OK); 
	}
	
	
	
}

