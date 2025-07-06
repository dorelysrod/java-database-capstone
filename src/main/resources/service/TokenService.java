package com.yourpackage.smartclinic.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public boolean validateToken(String token) {
        // TODO: Implement actual JWT validation
        return token != null && !token.isEmpty();
    }
}
