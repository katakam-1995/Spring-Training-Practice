package com.otsi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.otsi.model.UserDetailsDTO;
import com.otsi.repository.SpringSecurityRepository;

@Service
public class SpringSecurityServiceImpl implements UserDetailsService{
	
	@Autowired
	private SpringSecurityRepository springSecurityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDetailsDTO> details=springSecurityRepository.findByUserName(username);
		return new MyDetailsService(details.get());
	}

}
