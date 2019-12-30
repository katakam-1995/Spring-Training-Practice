package com.otsi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.otsi.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

	User findByUsername(String username);

}