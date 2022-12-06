package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.model.Cart;
import com.shopping.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

//	public Product findByCart(Cart cart);
//	public void deleteByCart(Cart cat);
}
