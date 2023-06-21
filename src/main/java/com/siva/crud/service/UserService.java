package com.siva.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.siva.crud.entity.UserEntity;
import com.siva.crud.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userrepo;

	// For adding the user to the database
	public UserEntity addUser(UserEntity usr) {

		return userrepo.save(usr);
	}

	// For retreiving all the user details from database
	public List<UserEntity> getAllUsrDetails() {

		return userrepo.findAll();
	}

	// retreiving the user details from database using id
	public ResponseEntity<UserEntity> getUsrDetailsById(int id) {
		Optional<UserEntity> iden = userrepo.findById(id);

		if (iden.isPresent()) {
			return new ResponseEntity<>(iden.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// updating the user details by using id
	public ResponseEntity<String> updateUsrDetailsById(int id, UserEntity updtdinpt) {

		Optional<UserEntity> iden = userrepo.findById(id);

		if (iden.isPresent()) {
			iden.get().setFirstname(updtdinpt.getFirstname());
			iden.get().setLastname(updtdinpt.getLastname());
			iden.get().setEm(updtdinpt.getEm());
			userrepo.save(iden.get());

			return new ResponseEntity<>("Updated the data in Database", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Provided Id is not available in the Database", HttpStatus.NOT_FOUND);
		}

	}

	// Delete all the users from the database
	public ResponseEntity<String> deleteAllUsrDetails() {
		userrepo.deleteAll();
		return new ResponseEntity<>("All the user details are deleted from the database", HttpStatus.NO_CONTENT);
	}

	// Delete the user details by id
	public String deleteUsrDetailsById(int id) {

		Optional<UserEntity> iden = userrepo.findById(id);
		if (iden.isPresent()) {
			userrepo.deleteById(id);
			String response = "User details of Id " + id + " has been deleted";
			return response;
		}
		else {
			return "Provided Id is not found in the database.";
		}
	}

}
