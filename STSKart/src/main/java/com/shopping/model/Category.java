package com.shopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
	
	private String Cname;
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
//	private List<Product> categoryProducts = new ArrayList<>();
//	
	
}
