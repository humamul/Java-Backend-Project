package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.exception.SellerException;
import com.shopping.exception.CustomerException;
import com.shopping.model.Address;
import com.shopping.model.Customer;
import com.shopping.model.CustomerDTO;
import com.shopping.model.Product;

@Service
public interface CustomerService {
	
	public Customer createAccount(Customer cum) throws CustomerException;
	
	public Address setTheAddress(Address add,Integer id) throws CustomerException;
	
	public String addProduct(Integer i,Integer cusId)throws CustomerException;
	
	public List<Product> getCart(Integer cusId)throws CustomerException;
	
	public Product removeFromCart(Integer cusid,Integer cartProId)throws CustomerException;

	public Customer deleteAccont(String email, String password) throws CustomerException;
}
