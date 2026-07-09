package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        LOGGER.info("Configuring SecurityFilterChain");
        
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/authenticate").permitAll() // Allow unauthenticated access to the JWT generation endpoint
            .anyRequest().authenticated()
            .and()
            .httpBasic(); // Optional, allows basic auth on other endpoints if we had them

        return http.build();
    }
}
