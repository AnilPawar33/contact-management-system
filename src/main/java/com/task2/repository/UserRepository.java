package com.task2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

		Optional<User> findByUsername(String username);
}
