package com.lcwd.user.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserid(randomUserId);
		System.out.println("User data: " + user.getName() + " | " + user.getEmail() + " | " + user.getAbout());

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public User getUser(String userId) {

		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found : " + userId));
	}

	@Override
	public void deleteUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found : " + userId));
		userRepository.delete(user);

	}

	@Override
	public User updateUser(User user, String userId) {
		User oldUser = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found : " + userId));

		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
		oldUser.setAbout(user.getAbout());

		User save = userRepository.save(oldUser);

		return save;
	}

	@Override
	public User getSingleUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found : " + userId));
		return user;
	}

}
