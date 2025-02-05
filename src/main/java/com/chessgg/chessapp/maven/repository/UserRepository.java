package com.chessgg.chessapp.maven.repository;

import com.chessgg.chessapp.maven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // Marks this interface as a repository, a part of Spring's component scan
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their username. This is useful for authentication or profile lookup.
     * 
     * @param username The username to search for.
     * @return An optional user matching the username.
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds a user by their email. This method helps with user login or registration via email.
     * 
     * @param email The email to search for.
     * @return An optional user matching the email.
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds a user by their Facebook link, allowing the user to log in using their social media.
     * 
     * @param facebookLink The Facebook link to search for.
     * @return An optional user with the specified Facebook link.
     */
    Optional<User> findByFacebookLink(String facebookLink);

    /**
     * Finds a user by their Instagram link.
     * 
     * @param instagramLink The Instagram link to search for.
     * @return An optional user with the specified Instagram link.
     */
    Optional<User> findByInstagramLink(String instagramLink);

    /**
     * Finds a user by their Twitter link.
     * 
     * @param twitterLink The Twitter link to search for.
     * @return An optional user with the specified Twitter link.
     */
    Optional<User> findByTwitterLink(String twitterLink);

    /**
     * Finds a user by their Twitch link.
     * 
     * @param twitchLink The Twitch link to search for.
     * @return An optional user with the specified Twitch link.
     */
    Optional<User> findByTwitchLink(String twitchLink);

    /**
     * Debugging utility method to print user information. This is used primarily for logging and debugging.
     * 
     * @param username The username of the user to fetch and print.
     */
    default void debugUserInfo(String username) {
        findByUsername(username).ifPresent(user -> {
            System.out.println("Debugging User Info:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password (hashed): " + user.getPassword());
        });
    }
}
