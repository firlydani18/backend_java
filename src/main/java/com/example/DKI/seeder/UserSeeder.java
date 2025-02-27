package com.example.DKI.seeder;

import com.example.DKI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public UserSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            seedUsers();
        }
    }

    private void seedUsers() {
        userRepository.seedUser("admin", "password");

        System.out.println("Users seeded successfully.");
    }
}
