package com.backend.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.backend.entities.User;
import com.backend.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;


	public User findByUserName(String username) {
		User user = em.find(User.class, username);
		return user;
	}

}