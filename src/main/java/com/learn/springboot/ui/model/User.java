package com.learn.springboot.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class User extends BaseUser{
	
	
	@NotNull(message = "First Name should not be Null")
	@NotBlank(message = "First Name should not be blank")
	private String firstName;
	
	@NotNull(message = "Last Name should not be Null")
	@NotBlank(message = "Lst Name should not be blank")
	private String lastName;
	
	@NotNull(message = "Email should not be Null")
	@NotBlank(message = "Email should not be blank")
	@Email(message = "Please provide valid email address")
	private String email;
	   
	
	
	public User() {
		
	}

	/*
	 * public User(String firstName, String lastName, String email, String id) {
	 * super(); this.firstName = firstName; this.lastName = lastName; this.email =
	 * email; this.id = id; }
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
