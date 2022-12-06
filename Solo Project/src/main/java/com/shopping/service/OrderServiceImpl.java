package com.shopping.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.CustomerException;
import com.shopping.model.Cart;
import com.shopping.model.Customer;
import com.shopping.model.Orders;
import com.shopping.model.Product;
import com.shopping.model.SellerProducts;
import com.shopping.repository.CartRepository;
import com.shopping.repository.CustomerRepo;
import com.shopping.repository.OrderRepo;
import com.shopping.repository.ProductRepo;
import com.shopping.repository.SellerProductRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private CustomerRepo cr;
	@Autowired
	private SellerProductRepo spr;
	@Autowired
	private OrderRepo or;
	@Autowired
	private ProductRepo pr;
	@Autowired
	private CartRepository cartr;
	@Override
	public Product buyNow(Integer cusId, Integer sproId) throws CustomerException {
		Optional<Customer> oc = cr.findById(cusId);
		if(oc.isPresent()) {
			Optional<SellerProducts> po = spr.findById(sproId);
			
			if(po.isPresent()) {
				
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
				
				Customer c = oc.get();
				
				Orders orders = new Orders();
				c.getOrdersList().add(orders);
				orders.setCustomer3(c);
				orders.setOrderDate(LocalDateTime.now());
				orders.setOrderStatus("ordered");
				orders.getOrdered().add(p);
				pr.save(p);
				or.save(orders);
				return p;
				
			}else throw new CustomerException("seller product Id Invalid");
			
			
			
		}else throw new CustomerException("Customer Id Invalid");
		
	}

	@Override
	public List<Product> orderAllCartProducts(Integer cusId) throws CustomerException {
		
		Optional<Customer> oc = cr.findById(cusId);
		if(oc.isPresent()) {
		Customer c = oc.get();
		List<Product> l = c.getCart().getProductList();
		
		Orders orders = new Orders();
		c.getOrdersList().add(orders);
		
		
		
		orders.setCustomer3(c);
		orders.setOrderDate(LocalDateTime.now());
		orders.setOrderStatus("ordered");
		orders.getOrdered().addAll(l);
		c.getCart().getProductList().removeAll(l);
		pr.deleteAll(l);
		or.save(orders);
		return l;
		}else throw new CustomerException("Customer id is wrong");
		
	}

	@Override
	public List<Orders> getAllOrders(Integer cusId) throws CustomerException {
		
		Optional<Customer> oc = cr.findById(cusId);
		if(oc.isPresent()) {
			Customer c = oc.get();

		List<Orders> l2 =	c.getOrdersList();
			
		return l2;
		}else throw new CustomerException("Customer id Is wrong");
		
	}
	

}
