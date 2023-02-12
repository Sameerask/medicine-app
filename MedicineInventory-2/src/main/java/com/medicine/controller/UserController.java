package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.dto.UserDto;
import com.medicine.entity.Medicine;
import com.medicine.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	 private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody UserDto userDto) 
	{
		String msg = userService.createUser(userDto);
	     System.out.println(msg);
	   return msg;
	   }
	
	@PostMapping("/user/login")
	public ResponseEntity<String> login(@RequestBody UserDto loginCredentials){
		if(userService.validateUser(loginCredentials.getUsername(),loginCredentials.getPassword())) {
			return ResponseEntity.ok("Login successful.");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines(){
		return userService.getAllMedicines();
	}

}
