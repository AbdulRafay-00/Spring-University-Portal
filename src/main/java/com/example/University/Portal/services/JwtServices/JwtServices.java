package com.example.University.Portal.services.JwtServices;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.University.Portal.Database_Connection.LoginInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
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
    
            public String jwt_token_gen (LoginInfo loginInfo){
                HashMap<String, Object> clai = new HashMap<>();
                clai.put("role", loginInfo.getRole());
                return Jwts.builder()
                    .claims()
                    .add(clai)
                    .subject(loginInfo.getEmail())
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


            private Claims extraAllClaims(String token){
                return Jwts.parser()
                .verifyWith(keygeb())
                .build()
                .parseSignedClaims(token)
                .getPayload();
            }


            private<T> T extractClaims(String token , Function<Claims, T> claimsResolver){
                final Claims claims = extraAllClaims(token);
                return claimsResolver.apply(claims);

            }

// extraction of payload values
            public String extractUserName(String token){
                return extractClaims(token, Claims::getSubject);
            }
            private boolean isTokenExpire(String token){
                return extractClaims(token, Claims::getExpiration).before(new Date());
            }
            public String extractRole(String token){
                return extractClaims(token, claims -> (String) claims.get("role"));
            }
            

            // validate token
            public boolean validateToken (String token,  UserDetails userDetails){
                final String username = extractUserName(token);
                return (username.equals(userDetails.getUsername()) && !isTokenExpire(token) );
            }


}
