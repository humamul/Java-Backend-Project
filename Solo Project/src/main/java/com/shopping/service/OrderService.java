package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.exception.CustomerException;
import com.shopping.model.Orders;
import com.shopping.model.Product;

@Service
public interface OrderService {

	public Product buyNow(Integer cusId,Integer sproId)throws CustomerException;
	
	public List<Product> orderAllCartProducts(Integer cusId)throws  CustomerException;

	public List<Orders> getAllOrders(Integer cusId) throws CustomerException;
	
}
