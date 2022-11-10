package com.shopping.service;

import org.springframework.stereotype.Service;

import com.shopping.exception.AdminException;
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
}
