package com.security.app_security.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtService {
    //TODO: Replace my JWT dependency with auth0
    private static final String SECRET_KEY = "5d67276d6b236e2fe0e0979ba8c4e20f206b006b9d35ada86a2772451fbc12fd";
    private static final Long EXPIRATION_TIME = 1080800000L;

    private SecretKey key() {
        byte[] bytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key())
                .compact();
    }

    //    Responsible for bring all claims(issued, expirations, subject,ext)
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Boolean isValid(String token, String username) {
        return (extractUsername(token).equals(username) && !isExpired(token));
    }

    private Boolean isExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
