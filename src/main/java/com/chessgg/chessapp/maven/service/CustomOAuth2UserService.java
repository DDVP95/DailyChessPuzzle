package com.chessgg.chessapp.maven.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    /**
     * Loads the user information from an external OAuth2 provider (e.g., Chess.com, Lichess).
     * This method is called after a successful OAuth2 login.
     *
     * @param userRequest The request containing the OAuth2 details for the user.
     * @return The authenticated OAuth2 user with the necessary details.
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        // Load user details from the OAuth2 provider (default behavior)
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // Here, you can map the OAuth2User details to your internal User entity
        // Custom logic can be added to map details like name, email, profile picture
        System.out.println("User attributes: " + oAuth2User.getAttributes());

        return oAuth2User;
    }
}
