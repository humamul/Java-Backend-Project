package com.shopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data 

public class Customer extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	private Address address;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer2")
	private Cart cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer1",orphanRemoval = true)
	private List<Order> ordersList = new ArrayList<>() ;
	
//	private Map<product, >
	
}

