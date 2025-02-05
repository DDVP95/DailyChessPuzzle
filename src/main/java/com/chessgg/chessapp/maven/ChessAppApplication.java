package com.chessgg.chessapp.maven;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.time.Year;

<<<<<<< HEAD
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
=======
@SpringBootApplication  // Marks this class as the main entry point for the Spring Boot application.
public class ChessAppApplication {

    public static void main(String[] args) {
        // Print the current directory to verify if the .env file is in the correct location.
        System.out.println("Current Directory: " + new File(".").getAbsolutePath());

        // Load environment variables from the .env file using the Dotenv library.
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Check if the .env file is loaded successfully.
        if (dotenv.entries().isEmpty()) {
            System.out.println("⚠️ .env file NOT found or is empty!");  // Warn if .env is missing or empty.
>>>>>>> 295a1a5 (Documentation/Commenting final version)
        } else {
            System.out.println("✅ .env file loaded successfully!");
        }

<<<<<<< HEAD
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
=======
        // Print each loaded environment variable to confirm they are being set correctly.
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());  // Set the environment variable as a system property.
            System.out.println("Loaded ENV: " + entry.getKey() + " = " + entry.getValue());
        });

        // Run the Spring Boot application.
        SpringApplication.run(ChessAppApplication.class, args);
    }

    /**
     * A method that runs after the Spring Boot application context is initialized.
     * It prints out the loaded properties to ensure they have been correctly set.
     */
    @PostConstruct
    public void init() {
        System.out.println("✅ Checking loaded properties...");
        // Print sensitive properties (passwords, etc.) for debugging purposes.
>>>>>>> 295a1a5 (Documentation/Commenting final version)
        System.out.println("SECURITY_USER_PASSWORD: " + System.getProperty("SECURITY_USER_PASSWORD"));
        System.out.println("LOGGING_LEVEL_SPRING: " + System.getProperty("LOGGING_LEVEL_SPRING"));
    }
}
