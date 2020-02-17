package com.emblassignment.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.emblassignment.springboot.model.PersonInfo;
import com.emblassignment.springboot.service.PersonInfoService;
import com.emblassignment.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
// @Validated
public class PersonInfoController {

	public static final Logger logger = LoggerFactory.getLogger(PersonInfoController.class);

	@Autowired
	PersonInfoService personInfoService;

	// ------Retrieve All Persons ----------

	@RequestMapping(value = "/personInfo/", method = RequestMethod.GET)
	public ResponseEntity<List<PersonInfo>> listOfAllPerson() {
		List<PersonInfo> persons = personInfoService.findAllPersonDetails();
		if (persons.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PersonInfo>>(persons, HttpStatus.OK);
	}

	// -------Retrieve Single Person--------

	@RequestMapping(value = "/personInfo/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPerson(@PathVariable("id") Long id) {
		logger.info("Fetching Person with id {}", id);
		PersonInfo person = personInfoService.findById(id);
		if (person == null) {
			logger.error("Person with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Person with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PersonInfo>(person, HttpStatus.OK);
	}
	
	
	// -------Create a Person-------------

	@RequestMapping(value = "/personInfo/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody PersonInfo personInfo, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", personInfo);

		if (personInfoService.isUserExist(personInfo)) {
			logger.error("Unable to create. A Person with first name and Last Name {} already exist", personInfo.getFirst_name()+" "+ personInfo.getLast_name());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Person with name " + 
					personInfo.getFirst_name()+" "+ personInfo.getLast_name() + " already exist."),HttpStatus.CONFLICT);
		}
		personInfoService.savePerson(personInfo);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/personInfo/{id}").buildAndExpand(personInfo.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------- Update a Person Information----------------

	@RequestMapping(value = "/personInfo/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePerson(@PathVariable("id") Long id, @RequestBody PersonInfo person) {
		logger.info("Updating Person with id {}", id);

		PersonInfo currentUser = personInfoService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to update. Person Info with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Person Info with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setFirst_name(person.getFirst_name());
		currentUser.setLast_name(person.getLast_name());
		currentUser.setAge(person.getAge());
		currentUser.setFavourite_colour(person.getFavourite_colour());
		currentUser.setHobbies(person.getHobbies());

		personInfoService.updatePerson(currentUser);
		return new ResponseEntity<PersonInfo>(currentUser, HttpStatus.OK);
	}

	// -------- Delete a Person Information----------

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/personInfo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		logger.info("Fetching & Deleting Person with id {}", id);

		PersonInfo peron = personInfoService.findById(id);
		if (peron == null) {
			logger.error("Unable to delete. Person with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Person with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		personInfoService.deleteUserById(id);
		return new ResponseEntity<PersonInfo>(HttpStatus.NO_CONTENT);
	}

	// -------- Delete All Person------------

	@RequestMapping(value = "/personInfo/", method = RequestMethod.DELETE)
	public ResponseEntity<PersonInfo> deleteAllUsers() {
		logger.info("Deleting All Persons");

		personInfoService.deleteAllPersons();
		return new ResponseEntity<PersonInfo>(HttpStatus.NO_CONTENT);
	}


}
