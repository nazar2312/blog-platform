package com.portfolio.blog.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationServiceInterface {
    UserDetails authenticate(String email, String password);
    String generateToken(UserDetails details);
    String extractToken(HttpServletRequest request);
    String extractUsername(String token);
    UserDetails validateToken(String token);
}
