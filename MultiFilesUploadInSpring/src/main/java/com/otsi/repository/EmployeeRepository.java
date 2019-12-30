package com.otsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	void save(String setFilePath);

}
