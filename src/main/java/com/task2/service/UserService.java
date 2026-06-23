package com.task2.service;

import com.task2.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	User findByUsername(String username);

}
