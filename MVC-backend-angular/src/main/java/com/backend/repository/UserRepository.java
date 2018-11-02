package com.backend.repository;

import com.backend.entities.User;

public interface UserRepository {
	
	/**
	 * find USER by UK-UserName
	 * 
	 * @param username
	 * @return
	 */
	User findByUserName(String username);

}