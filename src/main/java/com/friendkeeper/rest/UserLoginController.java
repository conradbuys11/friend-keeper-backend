package com.friendkeeper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendkeeper.entity.UserLogin;
import com.friendkeeper.service.UserLoginService;

@RestController
@RequestMapping("/api/user_logins")
public class UserLoginController {
	
	@Autowired
	UserLoginService service;
	
	@GetMapping("/{id}")
	public UserLogin getLogin(@PathVariable int id) {
		UserLogin login = service.getLogin(id);
		if(login == null) {
			throw new UserNotFoundException("Login info not found.");
		}
		return login;
	}
	
	@PostMapping("")
	public UserLogin addLogin(@RequestBody UserLogin login) {
		login.setId(0);
		service.saveLogin(login);
		return login;
	}
	
	@PutMapping("")
	public UserLogin updateLogin(@RequestBody UserLogin login) {
		service.saveLogin(login);
		return login;
	}
	
	@DeleteMapping("/{id}")
	public String deleteLogin(@PathVariable int id) {
		UserLogin login = service.getLogin(id);
		if(login == null) {
			throw new UserNotFoundException("Login info not found.");
		}
		service.deleteLogin(id);
		return "Deleted login info successfully.";
	}
	
}
