package com.task2.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.task2.entity.User;
import com.task2.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByUsername("admin").isEmpty()) {

            User admin = new User();

            admin.setUsername("admin");

            admin.setPassword(
            	"$2a$10$nRKJMdoSG.HxThFALQHs4eQEEzeFaOWwXwQAb5vqEnnM9Ti/jekkK"

            );

            admin.setRole("ADMIN");

            userRepository.save(admin);

            System.out.println("Admin user created");
        }
    }
}