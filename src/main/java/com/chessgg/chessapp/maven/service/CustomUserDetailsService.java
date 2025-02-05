package com.chessgg.chessapp.maven.service;

import com.chessgg.chessapp.maven.model.User;
import com.chessgg.chessapp.maven.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

<<<<<<< HEAD
=======
    // Constructor-based injection for the UserRepository
>>>>>>> 295a1a5 (Documentation/Commenting final version)
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

<<<<<<< HEAD
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Encoded password
                .authorities("ROLE_USER") // Example role; can be fetched dynamically if needed
=======
    /**
     * Loads a user by their username for authentication purposes.
     * This method is used by Spring Security during the login process to fetch user details.
     * 
     * @param username The username of the user to load.
     * @return A UserDetails object containing the user's details for authentication.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the repository by their username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return a Spring Security UserDetails object with the user's details (username, password, roles)
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Encoded password
                .authorities("ROLE_USER") // Default role for now, can be fetched dynamically if needed
>>>>>>> 295a1a5 (Documentation/Commenting final version)
                .build();
    }
}
