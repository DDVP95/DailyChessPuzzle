package com.chessgg.chessapp.maven.repository;

import com.chessgg.chessapp.maven.model.Achievement;
import com.chessgg.chessapp.maven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByUser(User user); // Fetch all achievements for a user
}
