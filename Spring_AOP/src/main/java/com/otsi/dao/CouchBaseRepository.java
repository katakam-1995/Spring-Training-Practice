package com.otsi.dao;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.otsi.model.Employee2;

@Repository
public interface CouchBaseRepository extends CouchbaseRepository<Employee2, String> {


	

}
