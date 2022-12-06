package com.shopping.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

	@NotNull
	private Integer CustomerId;
	
	private String email;
    private String streetNo;
	
	private String buildingName;
	
	private String city;
	
	private String state;
	

	private String country;
	
	private String pincode;
	
}
