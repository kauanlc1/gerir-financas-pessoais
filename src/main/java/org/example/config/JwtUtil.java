package org.example.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
public class JwtUtil {
    private String secretKey = "mySecretKey";  // Mudar

    // Cria um token JWT utilizando o nome de usuário e uma chave secreta
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)     // O usuário no token
                .setIssuedAt(new Date())  // Data de criação
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // Expiração do token (10 horas)
                .signWith(SignatureAlgorithm.HS256, secretKey)    // Algoritmo de assinatura e chave secreta
                .compact();
    }

    // Extrai o nome de usuário do token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // Verifica se o token é válido, se corresponde ao nome de usuário e se não expirou
    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
