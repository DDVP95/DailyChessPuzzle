package com.chessgg.chessapp.maven.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        // Load user details from Chess.com or Lichess APIs
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // Custom logic to map the user details to your User entity
        // For example, map attributes like name, email, profile picture
        System.out.println("User attributes: " + oAuth2User.getAttributes());

        return oAuth2User;
    }
}
