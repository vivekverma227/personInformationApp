package com.emblassignment.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emblassignment.springboot.model.PersonInfo;
import com.emblassignment.springboot.repositories.PersonInfoDao;



@Service("personInfoService")
public class PersonInfoServiceImpl implements PersonInfoService {
	@Autowired
	 PersonInfoDao personInfoDao;
	

	@Override
	public List<PersonInfo> findAllPersonDetails() {
		return personInfoDao.findAll();
	}


	@Override
	public PersonInfo findById(Long id) {
		return personInfoDao.findOne(id);
	}
	
	public String findByFName(String first_name) {
		return personInfoDao.findByFirstName(first_name);
	}
	
	public String findByLName(String last_name) {
		return personInfoDao.findByLastName(last_name);
	}

	@Override
	public boolean isUserExist(PersonInfo person) {
		String firstname = findByFName(person.getFirst_name());
		String lastname = findByLName(person.getLast_name());
		if(firstname != null && lastname != null)
		return  true;
		return false;
	}


	@Override
	public void savePerson(PersonInfo person) {
		personInfoDao.save(person);
	}


	@Override
	public void updatePerson(PersonInfo person) {
		savePerson(person);
		
	}


	@Override
	public void deleteUserById(Long id) {
		personInfoDao.delete(id);
	}


	@Override
	public void deleteAllPersons() {
		personInfoDao.deleteAll();		
	}

}
