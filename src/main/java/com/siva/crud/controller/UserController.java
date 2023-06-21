package com.siva.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siva.crud.entity.UserEntity;
import com.siva.crud.repository.UserRepo;
import com.siva.crud.service.UserService;

import jakarta.transaction.Transactional;

@RestController
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserEntity usr;
	
	@Autowired
	private UserService usrsrvc;
	
	@Autowired
	private UserRepo userrepo;
	
	
	@PostMapping("/adduser")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user ) {
		
//		System.out.println(user);
		return new ResponseEntity<>(usrsrvc.addUser(user), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getalluserdetails")
	public ResponseEntity<List<UserEntity>> getAllUserDetails() {
		
		return new ResponseEntity<>(usrsrvc.getAllUsrDetails(),HttpStatus.OK );
		
	}
	
	@GetMapping("/getuserdetailsbyid/{id}")
//	  Here we can use @PathVariable or @RequestParam the query string will change respectively.
//    For @PathVariable we use the path "/pathname/{varname}" to get the output we have to give "/pathname/{ourinput}".
//	  For @RequestParam we use the path "/pathname?varname=ourinput" to get the output we have to give "/pathname?varname=ourinput" in the search box.                      
	public ResponseEntity<UserEntity> getUserDetailsById(@PathVariable int id) {
		
		return usrsrvc.getUsrDetailsById(id);
	}
	
	@PutMapping("updateuserdetailsbyid/{ident}")
	public ResponseEntity<String> updateUserDetails(@PathVariable int ident, @RequestBody UserEntity bdy) {
		
		return usrsrvc.updateUsrDetailsById(ident, bdy);
	}
	
	@DeleteMapping("/deletealluserdetails")
	public ResponseEntity<String> deleteAllUserDetails() {
		
		return usrsrvc.deleteAllUsrDetails();
	}
	
	@DeleteMapping("/deleteuserdetailsbyid/{id}")
	public String deleteUsersById(@PathVariable int id) {
		
		return usrsrvc.deleteUsrDetailsById(id);
	}
	
	
	//Custom finder methods/Derived query methods
	
	@GetMapping("/getuserdetailsbylastname/{lstname}")
	public List<UserEntity> getUserDetailsByLastname(@PathVariable String lstname){
		
		return userrepo.findByLastname(lstname);
	}
	
	//For this delete custom finder method we have to use @Transactional annotation.
	//Otherwise we will get an runtime error
	//jakarta.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call
	@DeleteMapping("deleteuserdetailsbyemail/{emailid}")
	public String deleteUserDetailsByEmail(@PathVariable String emailid) {
		
		 userrepo.deleteByEm(emailid);
		 return "user deleted";
	}
	
}


















