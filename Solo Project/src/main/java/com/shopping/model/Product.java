package com.shopping.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productCartid;
	private Integer productId;
	
	private String productName;
	private double price;
	
	private Integer quantity;
	
	private String colour;

	private String dimension;
	private String specification;
	private String manufacutrer; 
	
//	@JsonIgnore
//	@ManyToOne (cascade = CascadeType.ALL)
//	private Cart cart;
	

//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Order order;
//	

	
	private String category;
	
}
