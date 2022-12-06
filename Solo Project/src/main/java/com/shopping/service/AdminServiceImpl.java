package com.shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.SellerException;
import com.shopping.model.Seller;
import com.shopping.model.SellerProducts;
import com.shopping.model.Product;
import com.shopping.repository.AdminRepository;
import com.shopping.repository.ProductRepo;
import com.shopping.repository.SellerProductRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private SellerProductRepo spr;
	@Autowired
	private ProductRepo pr;
	
	@Autowired
	private AdminRepository ar;
	@Override
	public Seller insertAdmin(Seller admin) throws SellerException {
		Optional<Seller> adm =  ar.findById(admin.getAdminId());
		if(adm.isPresent()) {
			throw new SellerException("Admin already Registered");
		}else {
				Seller a = ar.save(admin);
				return a;
		}
	}
	@Override
	public Seller deleteAdmin(String email, String password, String key) throws SellerException {
		// TODO Auto-generated method stub
		Seller admin = ar.findByEmailAndPassword(email, password);
		if(admin==null) throw new SellerException("Email or Password is Incorrect");
		
		ar.delete(admin);
		return admin;
	} 
	@Override
	public SellerProducts addProduct(SellerProducts product,Integer id) throws SellerException {
//		Optional<Product> op = pr.findById(product.getProductId());
//		if(op.isPresent()) {
//			throw new AdminException("Product Already Registered");
//		}else {
			Optional<Seller> adm = ar.findById(id);
			
			if(adm.isPresent()) {
				Seller seller = adm.get();
				seller.getSellerProducts().add(product);
				product.setSeller(seller);
			SellerProducts p=	spr.save(product);
			return p;
			}else throw new SellerException("Seller id is wrong");
			
//		}
	}
	

}
