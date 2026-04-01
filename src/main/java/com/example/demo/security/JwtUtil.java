//package com.example.demo.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//
//    private final String SECRET = "mysecretkey";
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
//                .signWith(SignatureAlgorithm.HS256, SECRET)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return getClaims(token).getSubject();
//    }
//
//    public boolean validateToken(String token, String username) {
//        String extractedUsername = extractUsername(token);
//        return extractedUsername.equals(username) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return getClaims(token).getExpiration().before(new Date());
//    }
//
//    private Claims getClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}





package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    // 🔥 IMPORTANT: keep long & secure secret key
    private final String SECRET =
            "my-super-secret-key-my-super-secret-key-1234567890";

    // ✅ Generate Token
    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(
                        io.jsonwebtoken.security.Keys.hmacShaKeyFor(
                                SECRET.getBytes(StandardCharsets.UTF_8)
                        ),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }

    // ✅ Extract username (subject)
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ Validate token
    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // ✅ Check expiration
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // ✅ Extract all claims
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(
                        io.jsonwebtoken.security.Keys.hmacShaKeyFor(
                                SECRET.getBytes(StandardCharsets.UTF_8)
                        )
                )
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}