package com.emblassignment.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emblassignment.springboot.model.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, Long> {
	
	@Query(value = "select first_name from persons where first_name = :first_name", nativeQuery = true)
	String findByFirstName(@Param(value = "first_name") String first_name);
	
	@Query(value = "select last_name from persons where last_name = :last_name", nativeQuery = true)
	String findByLastName(@Param(value = "last_name") String last_name);

}
