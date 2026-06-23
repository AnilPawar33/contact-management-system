package com.task2.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.task2.entity.User;
import com.task2.repository.UserRepository;
import com.task2.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {

	    return userRepository.findByUsername(username)
	            .orElseThrow(() ->
	                    new UsernameNotFoundException(
	                            "User Not Found"));
	}

}
