package com.rootzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rootzz.model.FamilyRootzz;

@Repository
public interface FamilyRootDao extends JpaRepository<FamilyRootzz, Integer> {

}
