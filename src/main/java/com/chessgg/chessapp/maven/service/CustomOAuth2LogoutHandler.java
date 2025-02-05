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

<<<<<<< HEAD
    public CustomOAuth2LogoutHandler(@Lazy OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof DefaultOidcUser) {
            DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
            String clientRegistrationId = (String) request.getAttribute("oauth2_authorized_client_registration_id");

=======
    // Constructor-based injection for the OAuth2AuthorizedClientService
    // @Lazy is used to prevent circular dependencies during bean initialization
    public CustomOAuth2LogoutHandler(@Lazy OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;  // Initialize the service for authorized clients
    }

    /**
     * Handles the logout process for users authenticated via OAuth2.
     * This method will clear the OAuth2 client information from the session
     * when the user logs out.
     * 
     * @param request The HTTP request that triggered the logout
     * @param response The HTTP response for the logout process
     * @param authentication The authentication information of the logged-in user
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof DefaultOidcUser) {
            // Only process logout if the user is authenticated via OAuth2 (OidcUser)
            DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
            String clientRegistrationId = (String) request.getAttribute("oauth2_authorized_client_registration_id");

            // If client registration ID exists, remove the OAuth2 client details
>>>>>>> 295a1a5 (Documentation/Commenting final version)
            if (clientRegistrationId != null) {
                clientService.removeAuthorizedClient(clientRegistrationId, authentication.getName());
            }
        }
    }
}
