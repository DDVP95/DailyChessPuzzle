package com.chessgg.chessapp.maven.repository;

import com.chessgg.chessapp.maven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    Optional<User> findByUsername(String username);

    // Find user by email
    Optional<User> findByEmail(String email);

    // Additional social media link queries
    Optional<User> findByFacebookLink(String facebookLink);
    Optional<User> findByInstagramLink(String instagramLink);
    Optional<User> findByTwitterLink(String twitterLink);
    Optional<User> findByTwitchLink(String twitchLink);

    // Debugging utility (Optional)
    default void debugUserInfo(String username) {
        findByUsername(username).ifPresent(user -> {
            System.out.println("Debugging User Info:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password (hashed): " + user.getPassword());
        });
    }
}
