package com.shopping.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Table(name = "orderTable")  // order ke naam s kabhi table mat banana vrna SQL query execute nhi hogi
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	private LocalDateTime orderDate;
	
	private String orderStatus;
	
	
	@ManyToOne
	@JsonIgnore
	private Customer customer3;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Product> ordered = new ArrayList<>();
}

//create table order (order_id integer not null,
//order_date datetime(6), order_status varchar(255), customer1_customer_id integer, primary key (order_id)) engine=InnoDB

//create table address (address_id integer not null, building_name varchar(255), city varchar(255), country varchar(255),
//		pincode varchar(255), state varchar(255), street_no varchar(255), customer_customer_id integer, primary key (address_id)) engine=InnoDB;