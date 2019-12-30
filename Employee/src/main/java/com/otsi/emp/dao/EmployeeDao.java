package com.otsi.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.emp.model.EmployeeDTO;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeDTO, Integer>  {

}
