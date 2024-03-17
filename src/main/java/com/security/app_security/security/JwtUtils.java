package com.security.app_security.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtils {
    private static final String SECRET_KEY = "5d67276d6b236e2fe0e0979ba8c4e20f206b006b9d35ada86a2772451fbc12fd";
    private static final Long EXPIRATION_TIME = 1000000L;
    private final SecretKey key;

    public JwtUtils() {
        byte[] bytes = Decoders.BASE64URL.decode(SECRET_KEY);
        this.key = Keys.hmacShaKeyFor(bytes);
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
