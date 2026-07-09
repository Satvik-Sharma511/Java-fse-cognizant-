package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // Secret key for signing the JWT (Should ideally be in application.properties and at least 256 bits)
    private static final String SECRET = "mySuperSecretKeyForJwtAuthenticationWhichIsVeryLong"; 

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate");
        
        // Step 1: Read Authorization header and decode the username and password
        // The header looks like: "Basic dXNlcjpwd2Q="
        String base64Credentials = authHeader.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        
        // credentials format: "username:password"
        final String[] values = credentials.split(":", 2);
        String username = values[0];
        LOGGER.debug("Decoded Username: {}", username);

        // Step 2: Generate token based on the user retrieved in the previous step
        String token = generateJwt(username);
        
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        
        LOGGER.info("End authenticate");
        return response;
    }

    private String generateJwt(String user) {
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        JwtBuilder builder = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // Expire in 20 mins
                .signWith(key);

        return builder.compact();
    }
}
