package com.chessgg.chessapp.maven.config;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "ff";
        String storedHash = "$2a$10$..."; // Replace with the stored hash from the database

        boolean matches = encoder.matches(rawPassword, storedHash);
        System.out.println("Password matches: " + matches);
    }
}
