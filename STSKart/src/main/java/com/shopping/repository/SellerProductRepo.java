package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.SellerProducts;
import com.shopping.model.Product;

@Repository
public interface SellerProductRepo extends JpaRepository<SellerProducts, Integer>{
	
	public SellerProducts findByProductId(Product product);

}
