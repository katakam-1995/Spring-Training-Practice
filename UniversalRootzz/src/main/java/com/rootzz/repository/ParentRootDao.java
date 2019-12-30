package com.rootzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rootzz.model.Parent;

@Repository
public interface ParentRootDao extends  JpaRepository<Parent, Integer>{

}
