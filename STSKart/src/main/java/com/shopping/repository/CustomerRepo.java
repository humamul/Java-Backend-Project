package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Address;
import com.shopping.model.Customer;

@Repository	
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	public Customer findByCustomerId(Integer customerId);

}
