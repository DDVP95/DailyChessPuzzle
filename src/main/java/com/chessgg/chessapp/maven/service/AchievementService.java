package com.chessgg.chessapp.maven.service;

import com.chessgg.chessapp.maven.model.Achievement;
import com.chessgg.chessapp.maven.model.User;

import java.util.List;

public interface AchievementService {
    List<Achievement> getUserAchievements(User user); // Fetch achievements for a user
    Achievement addAchievement(User user, String title, String description, int xpReward); // Add new achievement
}
