package com.example.University.Portal.services.JwtServices;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtServices {
    
    String secretKey;
    JwtServices(){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey seckey = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(seckey.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException("Error generating secret key: " + e.getMessage());
        }
    }
    
            public String jwt_token_gen (String userName){
                HashMap<String, Object> clai = new HashMap<>();
    
                return Jwts.builder()
                    .claims()
                    .add(clai)
                    .subject(userName)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                    .and()
                    .signWith(keygeb())
                    .compact();
            }

            private SecretKey keygeb(){
                byte[] key = Base64.getDecoder().decode(secretKey);
                return Keys.hmacShaKeyFor(key);
            }
}
