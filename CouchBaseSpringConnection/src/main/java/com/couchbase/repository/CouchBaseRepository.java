package com.couchbase.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.couchbase.model.Student;

@Repository
public interface CouchBaseRepository extends CouchbaseRepository<Student, String> {

	@Query("#{#n1ql.selectEntity}")
	List<Student> findAll();
}
