package com.chessgg.chessapp.maven.serviceImpl;

import com.chessgg.chessapp.maven.model.User;
import com.chessgg.chessapp.maven.repository.UserRepository;
import com.chessgg.chessapp.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service  // Marks this class as a service for dependency injection
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor-based injection for the UserRepository and PasswordEncoder
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new user and saves them to the database.
     * Validates user details (username and email) to ensure uniqueness before proceeding with registration.
     * Password is salted and encoded before being saved.
     * 
     * @param user The user object containing registration details.
     * @return The saved user object.
     */
    @Override
    public User registerUser(User user) {
        validateUserDetails(user);  // Ensure no duplicate username or email
    
        // Generate a unique salt for the user and prepend it to the password
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
    
        // Salt the password and encode it before saving
        String saltedPassword = salt + user.getPassword();
        String encodedPassword = passwordEncoder.encode(saltedPassword);
        user.setPassword(encodedPassword);
    
        return userRepository.save(user);  // Save the user to the repository
    }

    /**
     * Finds a user by their username.
     * 
     * @param username The username of the user.
     * @return An optional user matching the username.
     */
    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Finds a user by their email.
     * 
     * @param email The email of the user.
     * @return An optional user matching the email.
     */
    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Resets the password for a user by email.
     * Prepares the password by salting and encoding it before saving.
     * 
     * @param email The email of the user whose password needs to be reset.
     * @param newPassword The new password for the user.
     */
    @Override
    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Email not found"));

        // Salt the new password and encode it
        String saltedPassword = user.getSalt() + newPassword;
        user.setPassword(passwordEncoder.encode(saltedPassword));

        userRepository.save(user);  // Save the updated user with the new password
    }

    /**
     * Validates the user's registration details, ensuring the username and email are unique.
     * 
     * @param user The user object to validate.
     * @throws IllegalArgumentException if the username or email already exists.
     */
    private void validateUserDetails(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username '" + user.getUsername() + "' already exists.");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email '" + user.getEmail() + "' already exists.");
        }
    }
}
