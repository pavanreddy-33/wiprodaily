package com.wipro.jwtdemo.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration-ms:3600000}")
  private long expirationMs;

  private Key signingKey() {
    return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
  }

  public String generateToken(String username) {
    Date now = new Date();
    return Jwts.builder()
      .setSubject(username)
      .setIssuedAt(now)
      .setExpiration(new Date(now.getTime() + expirationMs))
      .signWith(signingKey(), SignatureAlgorithm.HS256)
      .compact();
  }

  public String extractUsername(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(signingKey())
      .build()
      .parseClaimsJws(token)
      .getBody()
      .getSubject();
  }
}
