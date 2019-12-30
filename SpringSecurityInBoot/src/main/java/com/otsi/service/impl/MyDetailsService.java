package com.otsi.service.impl;

import java.util.Arrays;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.otsi.model.UserDetailsDTO;

import org.springframework.security.core.userdetails.User;


public class MyDetailsService implements UserDetails {

	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	
	public MyDetailsService(UserDetailsDTO user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+authorities.toString()));
		String role=authorities.toString();
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+role));
	}

	@Override
	public String getPassword() {
		//return "password";
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
