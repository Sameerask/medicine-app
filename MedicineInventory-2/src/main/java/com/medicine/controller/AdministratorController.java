package com.medicine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dto.AdministratorDto;
import com.medicine.dto.UserDto;
import com.medicine.service.AdministratorService;

@RestController
@RequestMapping("/admin")
public class AdministratorController {
	@Autowired
	 private AdministratorService administratorService;
	
	

	
	@PostMapping("/registerAdmin")
	public String registerUser(@RequestBody AdministratorDto administratorDto) 
	{
		String newUser = administratorService.createUser(administratorDto);
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(newUser, HttpStatus.CREATED);
		//return responseEntity;
		System.out.println(newUser);
		return newUser;
	   }
	@PostMapping("/admin/login")
	public ResponseEntity<String> login(@RequestBody AdministratorDto loginCredentials){
		if(administratorService.validateAdmin(loginCredentials.getUsername(),loginCredentials.getPassword())) {
			return ResponseEntity.ok("Login successful.");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}

}
