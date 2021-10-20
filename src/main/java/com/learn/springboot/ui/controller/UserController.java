package com.learn.springboot.ui.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.serviceinterface.IUserService;
import com.learn.springboot.ui.model.User;

@RestController
@RequestMapping("/users")//http://localhost:8080/users
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping
	public String getAllUsers(@RequestParam(value = "pageNo", defaultValue = "1" ,required = false) Integer pageNo,
			@RequestParam(value = "limit", required = false) Integer limit) {
		
		return "get all users was called, page no = "+pageNo+" and limit = "+limit;
	}
	
	@GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		
		User user = userService.getuser(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@Valid@RequestBody User user) {
		
		User returnVal = userService.createUser(user);
		
		return new ResponseEntity<User>(returnVal, HttpStatus.OK); 
	}
	
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		User returnVal = userService.updateUser(user);
		
		return new ResponseEntity<User>(returnVal, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{userId}")
	public String deletUser(@PathVariable Integer userId) {
		
		return "delete user was called"+userId;
	}

}
