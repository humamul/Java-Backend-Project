package com.shopping.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyErrorDetails {
	private LocalDateTime ldt;
	private String Message;
	private String Description;
}
