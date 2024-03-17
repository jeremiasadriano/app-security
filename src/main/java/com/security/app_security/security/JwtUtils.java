package com.security.app_security.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;


@Component
public class JwtUtils {
    private static final String SECRET_KEY = "minhaSenhaSuperSeguraFilhoEntaoREl4X4RNBRother";
    private static final String ALGORITHM = "HmacSHA512";
    private static final Long EXPIRATION_TIME = 1000000L;
    private final SecretKey key;

    public JwtUtils() {
        byte[] bytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        this.key = new SecretKeySpec(bytes, ALGORITHM);
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
