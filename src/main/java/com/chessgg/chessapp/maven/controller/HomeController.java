package com.chessgg.chessapp.maven.controller;

import com.chessgg.chessapp.maven.model.Puzzle;
import com.chessgg.chessapp.maven.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PuzzleService puzzleService;

    @GetMapping("/")
    public String index(Model model) {
        // Handle authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                model.addAttribute("username", ((UserDetails) principal).getUsername());
            } else if (principal instanceof DefaultOidcUser) {
                DefaultOidcUser oidcUser = (DefaultOidcUser) principal;
                String displayName = oidcUser.getAttribute("name");
                if (displayName == null) {
                    displayName = oidcUser.getAttribute("email");
                }
                model.addAttribute("username", displayName != null ? displayName : "User");
            } else {
                model.addAttribute("username", "Guest");
            }
        } else {
            model.addAttribute("username", "Guest");
        }

        // Fetch the daily puzzle
        Optional<Puzzle> dailyPuzzle = puzzleService.getDailyPuzzle(LocalDate.now());
        if (dailyPuzzle.isPresent()) {
            model.addAttribute("dailyPuzzle", dailyPuzzle.get());
        } else {
            model.addAttribute("puzzleError", "Failed to load the puzzle. Please try again later.");
        }

        return "index"; // Render index.html
    }

    @GetMapping("/index.html")
    public String indexHtml(Model model) {
        return index(model);
    }

    @GetMapping("/logout-success")
    public String logoutSuccess(Model model) {
        model.addAttribute("message", "You have successfully logged out.");
        return "index";
    }
}
