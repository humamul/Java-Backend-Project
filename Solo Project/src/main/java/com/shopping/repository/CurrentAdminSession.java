package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.CurrentUserSession;

@Repository
public interface CurrentAdminSession extends JpaRepository<CurrentUserSession, Integer> {

	public CurrentUserSession findByUuid(String key);
	
}
