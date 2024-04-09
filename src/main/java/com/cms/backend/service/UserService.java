package com.cms.backend.service;

import com.cms.backend.model.UserModel;
import com.cms.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private final Map<String, UserModel> users = new HashMap<>();

    public UserModel registerUser(UserModel user) {
        // Check if user already exists
        if (users.containsKey(user.getEmail())) {
            return null; // User already exists, registration failed
        } else {
            // Add the new user
            return userRepository.save(user);
        }
    }

    public UserModel authenticate(UserModel user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElse(null);
    }

    public boolean userExists(String email) {
        return users.containsKey(email);
    }
}
