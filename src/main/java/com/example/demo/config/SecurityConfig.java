package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll(); // permit access
                    auth.anyRequest().authenticated(); // authenticated
                })
                .oauth2Login(Customizer.withDefaults()) // OAuth Login (Google, Facebook)
                .formLogin(Customizer.withDefaults()) // Login Form (username, password)
                .build();
    }
}
