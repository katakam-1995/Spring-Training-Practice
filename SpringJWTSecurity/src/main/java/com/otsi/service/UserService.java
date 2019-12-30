package com.otsi.service;

import java.util.Optional;

import com.otsi.model.User;

public interface UserService {

	Iterable<User> findAll();

	Optional<User> findById(Integer id);
	
	User findByUserName(String userName);

}
