package com.chessgg.chessapp.maven.serviceImpl;

import com.chessgg.chessapp.maven.model.User;
import com.chessgg.chessapp.maven.repository.UserRepository;
import com.chessgg.chessapp.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        validateUserDetails(user);
    
        // Generate a unique salt for the user
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
    
        // Prepend the salt to the raw password before encoding
        String saltedPassword = salt + user.getPassword();
        String encodedPassword = passwordEncoder.encode(saltedPassword);
        user.setPassword(encodedPassword);
    
        return userRepository.save(user);
    }
    
   
    

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Email not found"));

        // Prepend the user's salt to the new password before encoding
        String saltedPassword = user.getSalt() + newPassword;
        user.setPassword(passwordEncoder.encode(saltedPassword));

        userRepository.save(user);
    }

    private void validateUserDetails(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username '" + user.getUsername() + "' already exists.");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email '" + user.getEmail() + "' already exists.");
        }
    }
}
