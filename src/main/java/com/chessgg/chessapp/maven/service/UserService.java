package com.chessgg.chessapp.maven.service;

import com.chessgg.chessapp.maven.model.User;

import java.util.Optional;

public interface UserService {

    /**
     * Registers a new user by saving the user details to the database.
     * 
     * @param user The user object containing the registration details.
     * @return The registered user.
     */
    User registerUser(User user);

    /**
     * Finds a user by their username.
     * 
     * @param username The username to search for.
     * @return An optional user matching the username.
     */
    Optional<User> findUserByUsername(String username);

    /**
     * Finds a user by their email address.
     * 
     * @param email The email to search for.
     * @return An optional user matching the email.
     */
    Optional<User> findUserByEmail(String email);

    /**
     * Resets the password for the user identified by their email.
     * 
     * @param email The email of the user who wants to reset their password.
     * @param newPassword The new password for the user.
     */
    void resetPassword(String email, String newPassword);
}
