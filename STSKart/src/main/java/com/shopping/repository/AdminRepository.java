package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Seller;

@Repository
public interface AdminRepository extends JpaRepository<Seller	, Integer>{
	
	public Seller findByEmailAndPassword(String email,String password);
	
}
