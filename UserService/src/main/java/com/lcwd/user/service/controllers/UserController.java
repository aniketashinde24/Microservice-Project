package com.lcwd.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// create
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	// get all user
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return "User Deleted with User id  " + id;
	}

	// update
	@PostMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
		User updateUser = userService.updateUser(user, id);
		return new ResponseEntity<User>(updateUser, HttpStatus.CREATED);
	}

	// get single user
	@GetMapping("/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable String id) {
		User user = userService.getSingleUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
