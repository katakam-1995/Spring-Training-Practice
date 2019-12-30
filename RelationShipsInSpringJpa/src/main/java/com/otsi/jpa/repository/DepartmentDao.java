package com.otsi.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.jpa.model.Department;

@Repository
public interface DepartmentDao extends  JpaRepository<Department, Integer> {


}
