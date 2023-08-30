package com.damian.auth.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                // disable CSRF protection
                .csrf().disable()
                .authorizeHttpRequests(
                        authorizeHttpRequest ->
                                authorizeHttpRequest
                                        .requestMatchers(HttpMethod.POST,
                                                "/auth/register",
                                                "/auth/login")
                                        .permitAll()
                );
        return http.build();
    }
}
