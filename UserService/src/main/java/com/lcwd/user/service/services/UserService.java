package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService {
	
	//user operations
	//create
	User saveUser(User user);
	
	//get all user 
	List<User> getAllUser();

	//get single user
	User getUser(String userId);
	
	//delete user
	void deleteUser(String userId);
	
	//update user 
	User updateUser(User user,String userId);
	
	//get single user
	User getSingleUser(String userId);
	
}
