package com.shopping.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	private String streetNo;
	
	private String buildingName;
	
	private String city;
	
	private String state;
	

	private String country;
	
	private String pincode;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	private Order order;
	
}
