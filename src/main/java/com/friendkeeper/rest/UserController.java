package com.friendkeeper.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendkeeper.entity.FKUser;
import com.friendkeeper.service.FKUserService;

@RestController
@RequestMapping("/api/customers")
public class UserController {

	@Autowired FKUserService userService;
	
	@GetMapping("")
	public List<FKUser> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	public FKUser getUser(@PathVariable int id) {
		FKUser user = userService.getUser(id);
		if(user == null) {
			throw new UserNotFoundException("User not found.");
		}
		return user;
	}
	
	@PostMapping("")
	public FKUser addUser(@RequestBody FKUser user) {
		//0 means "empty" for hibernate
		//it will create a new id for the table
		user.setId(0);
		userService.saveUser(user);
		return user;
	}
	
	@PutMapping("")
	public FKUser updateUser(@RequestBody FKUser user) {
		userService.saveUser(user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		FKUser user = userService.getUser(id);
		if(user == null) {
			throw new UserNotFoundException("User not found.");
		}
		userService.deleteUser(id);
		return "Deleted user successfully.";
	}
}
