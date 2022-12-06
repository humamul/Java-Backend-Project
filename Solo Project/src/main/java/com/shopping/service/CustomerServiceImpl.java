package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.SellerException;
import com.shopping.exception.CustomerException;
import com.shopping.model.Address;
import com.shopping.model.Cart;
import com.shopping.model.Customer;
import com.shopping.model.CustomerDTO;
import com.shopping.model.Orders;
import com.shopping.model.Product;
import com.shopping.model.SellerProducts;
import com.shopping.repository.AddressRepo;
import com.shopping.repository.CartRepository;
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
	@Autowired
	private CartRepository cartr;
	@Override
	public Customer createAccount(Customer cus) throws CustomerException {
		Cart cart = new Cart();
		List<Orders> ol = new ArrayList<>();
		cus.setOrdersList(ol);
		cus.setCart(cart);
//		cart.setCustomer2(cus);
		
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


			customer.getCart().getProductList().add(p);
//			p.setCart(customer.getCart());
			cr.save(customer);
	       
			return "Added to Cart ";
		}
		
	return "Not Found or Customer id is wrong";
	}

	@Override
	public List<Product> getCart(Integer cusId) throws CustomerException {
		
	Optional<Customer> ocOptional = 	cr.findById(cusId);
	if(ocOptional.isPresent()) {
		Customer customer = ocOptional.get();
		
		List<Product> l = customer.getCart().getProductList();
		return l;
		
		
	}
	else throw new CustomerException("Customer Not Found");
	
		
	}

	@Override
	public Product removeFromCart(Integer cusid, Integer cartProId) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> oc = cr.findById(cusid);
		if(oc.isPresent()) {
		Optional<Product> op = pr.findById(cartProId);
		    if(op.isPresent()) {
			Customer c = oc.get();
			c.getCart().getProductList().remove(op.get());
			Product p = op.get();
			pr.delete(p);
			
			return p;
			
			
		    }else throw new CustomerException("Product is not in the cart");
		}else throw new CustomerException("Customer id not valid");
	
	}

	@Override
	public Customer deleteAccont(String email, String password) throws CustomerException {
		Customer c = cr.findByEmail(email);
		if(c!=null) {
			if(c.getPassword().equals(password))
			cr.delete(c);
			else throw new CustomerException("Password is wrong");
		}else throw new CustomerException("Wrong Email");
		return c;
	}
	
	

}
