package org.dnyanyog.controller;

import java.util.List;


import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.User;
import org.dnyanyog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;

	// Create
	@PostMapping(path = "/user")
	public UserResponse addUser(@RequestBody UserRequest request) {

		return service.saveUser(request);
	}

//	//Update
//	@PutMapping(path = "/user/{id}")
//	public UserResponse updatebyid(@PathVariable long id,@RequestBody User userReq) {
//		return service.updateUserbyid(id, userReq);
//	}
	// Search
	@GetMapping(path = "/user/{id}")
	public User getUserbyid(@PathVariable long id) {
		return service.getUserbyid(id);
	}
	//Search by first_name
	@GetMapping(path = "/username/{firstName}")
	public User getUserByName(@PathVariable String firstName) {
		return service.getUserByName(firstName);
	}

	// Delete
	@DeleteMapping(path = "/user/{name}")
	public UserResponse removeUser(@PathVariable String name) {
		return service.removeUser(name);
	}

	// Display all
	@GetMapping(path = "/userall")
	public List<User> getallUser() {
		return service.allUser();
	}
	
	

}
