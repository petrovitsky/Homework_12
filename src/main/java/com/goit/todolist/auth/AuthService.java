package com.goit.todolist.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private User getUser() {
        return (User) getAuthentication().getPrincipal();
    }

    public String getUserName() {
        return getUser().getUsername();
    }

    public boolean hasAuthority(String role) {
        return getUser()
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(it -> it.equals(role));

    }
}
