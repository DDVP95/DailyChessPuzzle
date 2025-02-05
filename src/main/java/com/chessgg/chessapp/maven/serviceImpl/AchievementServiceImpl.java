/*package com.chessgg.chessapp.maven.serviceImpl;

import com.chessgg.chessapp.maven.model.User;
import com.chessgg.chessapp.maven.repository.UserRepository;
import com.chessgg.chessapp.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AchievementServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Add default values for new users
        user.setXp(0);
        user.setLevel(1);
        user.setLastLoginDate(LocalDate.now());
        user.setConsecutiveDaysLoggedIn(0);
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
    public void updateProfile(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateXPAndLevel(User user, int additionalXP) {
        user.setXp(user.getXp() + additionalXP);
        user.setLevel(user.getXp() / 1000); // Example leveling logic
        userRepository.save(user);
    }

    @Override
    public void updateLoginStreak(User user) {
        LocalDate today = LocalDate.now();
        if (user.getLastLoginDate().equals(today.minusDays(1))) {
            user.setConsecutiveDaysLoggedIn(user.getConsecutiveDaysLoggedIn() + 1);
        } else if (!user.getLastLoginDate().equals(today)) {
            user.setConsecutiveDaysLoggedIn(1); // Reset streak
        }
        user.setLastLoginDate(today);
        userRepository.save(user);
    }

    @Override
    public void resetPassword(String email, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
    
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("No user found with email: " + email);
        }
    
        User user = userOptional.get();
        user.setPassword(newPassword); // Ideally, encrypt this password using a PasswordEncoder
        userRepository.save(user);
    }
    
}
*/