package com.siva.crud.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component

public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String firstname;
	String lastname;
	String em;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(int id, String firstname, String lastname, String em) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.em = em;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", em=" + em + "]";
	}
	
	
		
	
	
}
