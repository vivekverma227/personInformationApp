package com.emblassignment.springboot.service;

import java.util.List;

import com.emblassignment.springboot.model.PersonInfo;


public interface PersonInfoService {

	List<PersonInfo> findAllPersonDetails();

	PersonInfo findById(Long id);

	boolean isUserExist(PersonInfo person);

	void savePerson(PersonInfo person);

	void updatePerson(PersonInfo person);

	void deleteUserById(Long id);

	void deleteAllPersons();



}
