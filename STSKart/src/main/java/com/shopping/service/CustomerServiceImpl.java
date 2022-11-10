package com.shopping.service;

import java.util.Optional;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.AdminException;
import com.shopping.exception.CustomerException;
import com.shopping.model.Address;
import com.shopping.model.Cart;
import com.shopping.model.Customer;
import com.shopping.model.CustomerDTO;
import com.shopping.model.Product;
import com.shopping.model.SellerProducts;
import com.shopping.repository.AddressRepo;
import com.shopping.repository.CustomerRepo;
import com.shopping.repository.ProductRepo;
import com.shopping.repository.SellerProductRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo cr;
	
	@Autowired
	private AddressRepo ar;
	@Autowired
	private ProductRepo pr;
	@Autowired
	private SellerProductRepo spr;
	
	@Override
	public Customer createAccount(Customer cus) throws CustomerException {
		
	Customer c =	cr.save(cus);
		
	
		
		
		return c;
		
	}

	@Override
	public Address setTheAddress(Address add,Integer customerId) throws CustomerException {
			Optional<Customer> co = cr.findById(customerId);
			if(co.isPresent()) {
				Customer c = co.get();
				c.setAddress(add);
				
				add.setCustomer(c);
				
				Address address = ar.save(add);
				ar.save(address);
				
				
				return add;
			}
			else
		throw new CustomerException("Customer id is wrong");
	}

	@Override
	public String addProduct(Integer i,Integer cusId) throws CustomerException {  ///adding to cart
		Optional<SellerProducts> po = spr.findById(i);
		Customer customer = cr.findByCustomerId(cusId);
		 
		
		
		if(po.isPresent()&& customer!=null) { 
			
			SellerProducts sp = po.get();
			Product p = new Product();
			
			p.setProductId(sp.getProductId());
			p.setCategory(sp.getCategory());
			p.setColour(sp.getCategory());
			p.setDimension(sp.getDimension());
			p.setManufacutrer(sp.getManufacutrer());
			p.setPrice(sp.getPrice());
			p.setProductName(sp.getProductName());
			p.setQuantity(sp.getQuantity());
			p.setSpecification(sp.getSpecification());

		
			if(customer.getCart()==null) {
				Cart cart = new Cart();
				customer.setCart(cart);
				cart.setCustomer2(customer);
				
				customer.getCart().getProductList().add(p);
				cr.save(customer);
			}
			else {
				System.out.println("###########################################################################");
			customer.getCart().setCustomer2(customer);
			customer.getCart().getProductList().add(p);
			cr.save(customer);
			
			System.out.println(customer.getCart().getProductList());
			
			System.out.println("###########################################################################");
			}
			
			
	       
			return "Added to Cart ";
		}
		
	return "Not Found";
	}

}
