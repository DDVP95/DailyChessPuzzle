package com.chessgg.chessapp.maven.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")  // Corresponds to the 'users' table in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)  // Makes the username field required and unique
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;  // The salt used for hashing the password

    @Column(nullable = false, unique = true)
    private String email;  // User's email

    @Column(unique = true)
    private String facebookLink;  // Link to the user's Facebook profile (if any)

    // Other social media links like Instagram, Twitch, etc.
    private String instagramLink;
    private String twitchLink;
    private String twitterLink;

    private String firstName;
    private String lastName;
    private String location;
    private String country;
    private String badge;
    private String language;
    private String timezone;

    // Player statistics
    private int puzzleRating = 1000;
    private int multiplayerRating = 1000;
    private int xp = 0;
    private int level = 1;
    private int totalDraws = 0;
    private int totalLosses = 0;
    private int totalWins = 0;
    private int totalGamesPlayed = 0;
    private int totalPuzzlesSolved = 0;
    private int consecutiveDaysLoggedIn = 0;

    private String aboutMe;  // The user's biography

    private LocalDate lastLoginDate;  // The last time the user logged in

    // Many-to-many relationship: A user can have multiple roles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();  // Set of roles the user has

    // Getters and Setters for all fields

    // Getters and Setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getTwitchLink() {
        return twitchLink;
    }

    public void setTwitchLink(String twitchLink) {
        this.twitchLink = twitchLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getPuzzleRating() {
        return puzzleRating;
    }

    public void setPuzzleRating(int puzzleRating) {
        this.puzzleRating = puzzleRating;
    }

    public int getMultiplayerRating() {
        return multiplayerRating;
    }

    public void setMultiplayerRating(int multiplayerRating) {
        this.multiplayerRating = multiplayerRating;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalDraws() {
        return totalDraws;
    }

    public void setTotalDraws(int totalDraws) {
        this.totalDraws = totalDraws;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public int getTotalPuzzlesSolved() {
        return totalPuzzlesSolved;
    }

    public void setTotalPuzzlesSolved(int totalPuzzlesSolved) {
        this.totalPuzzlesSolved = totalPuzzlesSolved;
    }

    public int getConsecutiveDaysLoggedIn() {
        return consecutiveDaysLoggedIn;
    }

    public void setConsecutiveDaysLoggedIn(int consecutiveDaysLoggedIn) {
        this.consecutiveDaysLoggedIn = consecutiveDaysLoggedIn;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
