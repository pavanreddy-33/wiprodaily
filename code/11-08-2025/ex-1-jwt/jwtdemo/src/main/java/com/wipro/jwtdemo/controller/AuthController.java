package com.wipro.jwtdemo.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.jwtdemo.util.JwtUtil;

@RestController
public class AuthController {
  private final JwtUtil jwtUtil;
  public AuthController(JwtUtil jwtUtil){ this.jwtUtil = jwtUtil; }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest req) {
    // demo only - replace with real user validation in production
    if ("admin".equals(req.getUsername()) && "pass".equals(req.getPassword())) {
      String token = jwtUtil.generateToken(req.getUsername());
      return ResponseEntity.ok(Map.of("token", token));
    }
    return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
  }

  @GetMapping("/getCurrentTime")
  public ResponseEntity<?> getCurrentTime() {
    return ResponseEntity.ok(Map.of("now", LocalDateTime.now().toString()));
  }

  public static class LoginRequest {
    private String username;
    private String password;
    public String getUsername(){ return username; }
    public void setUsername(String u){ this.username = u; }
    public String getPassword(){ return password; }
    public void setPassword(String p){ this.password = p; }
  }
}
