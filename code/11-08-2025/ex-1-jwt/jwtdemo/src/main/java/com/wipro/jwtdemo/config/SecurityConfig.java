package com.wipro.jwtdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll() // Allow /login without authentication
                .anyRequest().authenticated()          // All other endpoints need auth
            )
            .formLogin(login -> login.disable()) // Disable default login page
            .httpBasic(basic -> basic.disable()); // Disable Basic Auth

        return http.build();
    }
}