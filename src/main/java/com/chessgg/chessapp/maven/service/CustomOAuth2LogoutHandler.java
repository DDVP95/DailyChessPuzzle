package com.chessgg.chessapp.maven.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2LogoutHandler implements LogoutHandler {

    private final OAuth2AuthorizedClientService clientService;

    public CustomOAuth2LogoutHandler(@Lazy OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof DefaultOidcUser) {
            DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
            String clientRegistrationId = (String) request.getAttribute("oauth2_authorized_client_registration_id");

            if (clientRegistrationId != null) {
                clientService.removeAuthorizedClient(clientRegistrationId, authentication.getName());
            }
        }
    }
}
