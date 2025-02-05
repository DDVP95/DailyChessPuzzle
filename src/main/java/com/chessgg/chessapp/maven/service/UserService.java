package com.chessgg.chessapp.maven.service;

import com.chessgg.chessapp.maven.model.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

    void resetPassword(String email, String newPassword);
}
