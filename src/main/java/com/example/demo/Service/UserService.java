package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Reposotory.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ REGISTER LOGIC HERE (no ServiceImpl)
    public String register(User user) {

        // 🔥 encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 🔥 save user
        userRepository.save(user);

        return "User registered successfully";
    }
}