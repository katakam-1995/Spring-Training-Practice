package com.otsi.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otsi.jpa.model.Employee;

@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employee, Integer> {

	Page<Employee> findAllById(int id, Pageable pageable);

	Page<Employee> findAllByName(String name, Pageable sortedByName);
	
	
}
