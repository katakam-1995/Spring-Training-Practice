package com.otsi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.otsi.model.UserDetailsDTO;

@Repository
public interface SpringSecurityRepository extends JpaRepository<UserDetailsDTO, Integer>{

	Optional<UserDetailsDTO> findByUserName(String username);

}
