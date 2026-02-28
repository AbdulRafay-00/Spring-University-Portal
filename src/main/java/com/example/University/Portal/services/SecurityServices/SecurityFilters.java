package com.example.University.Portal.services.SecurityServices;
// package com.example.University.Portal.services;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityFilters {
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())

        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )

        .authorizeHttpRequests(auth -> auth
            .requestMatchers( "/signup/stuSignup/**", "/login/**","/admin/**").permitAll()
            .requestMatchers("/signup/techSignup").hasRole("ADMIN")
            .anyRequest().authenticated()
        )

        .build();
}

}



