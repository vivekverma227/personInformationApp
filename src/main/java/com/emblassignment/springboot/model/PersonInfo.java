package com.emblassignment.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PERSONS")
public class PersonInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "FIRST_NAME")
	private String first_name;

	@NotEmpty
	@Column(name = "LAST_NAME")
	private String last_name;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@NotEmpty
	@Column(name = "FAV_COLOUR", nullable = false)
	private String favourite_colour;

	@ElementCollection
	@CollectionTable(name = "hobbies_table", joinColumns = @JoinColumn(name = "person_id"))
	@Column(name = "hobbies")
	private List<String> hobbies = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFavourite_colour() {
		return favourite_colour;
	}

	public void setFavourite_colour(String favourite_colour) {
		this.favourite_colour = favourite_colour;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

}
