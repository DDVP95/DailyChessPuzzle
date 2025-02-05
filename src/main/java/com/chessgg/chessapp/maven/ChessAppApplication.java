package com.chessgg.chessapp.maven;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.time.Year;

@SpringBootApplication
public class ChessAppApplication {

    public static void main(String[] args) {
        // Print current directory to verify if .env is in the correct place
        System.out.println("Current Directory: " + new File(".").getAbsolutePath());

        // Load environment variables from .env
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Check if .env is actually loaded
        if (dotenv.entries().isEmpty()) {
            System.out.println("⚠️ .env file NOT found or is empty!");
        } else {
            System.out.println("✅ .env file loaded successfully!");
        }

        // Print each loaded environment variable
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
            System.out.println("Loaded ENV: " + entry.getKey() + " = " + entry.getValue());
        });

        SpringApplication.run(ChessAppApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("✅ Checking loaded properties...");
        System.out.println("SECURITY_USER_PASSWORD: " + System.getProperty("SECURITY_USER_PASSWORD"));
        System.out.println("LOGGING_LEVEL_SPRING: " + System.getProperty("LOGGING_LEVEL_SPRING"));
    }
}
