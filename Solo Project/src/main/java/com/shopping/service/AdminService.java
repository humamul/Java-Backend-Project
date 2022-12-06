package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.exception.SellerException;
import com.shopping.model.Seller;
import com.shopping.model.SellerProducts;
import com.shopping.model.Product;

@Service
public interface AdminService {

	public Seller insertAdmin(Seller admin) throws SellerException ;
	public Seller deleteAdmin(String email , String password,String key) throws SellerException ;
	
	public SellerProducts addProduct(SellerProducts product,Integer id) throws SellerException;
}
