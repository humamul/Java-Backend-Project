package com.shopping.service;

import org.springframework.stereotype.Service;

import com.shopping.model.CurrentUserSession;

@Service
public interface CurrentSession {
	
	
	public CurrentUserSession findByUuid();
	public CurrentUserSession findByUserId();
	
}
