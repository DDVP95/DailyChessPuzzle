/* package com.chessgg.chessapp.maven.controller;

import com.chessgg.chessapp.maven.model.User;
import com.chessgg.chessapp.maven.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional; // <-- Add this import

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest) {
        // Get the Optional<User> from the repository
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());

        // Check if the user is present
        if (optionalUser.isPresent()) {
            User user = optionalUser.get(); // Extract User from Optional
            // Check password (You should use hashed passwords in real applications)
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return "Login successful!";
            }
        }
        
        return "Invalid username or password.";
    }
}
 */