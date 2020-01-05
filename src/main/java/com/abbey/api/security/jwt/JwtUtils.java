package com.abbey.api.security.jwt;

import com.abbey.api.services.UserDetailsImplementation;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @Value("${abbey.app.jwtExpirationMs}")
    private int jwtExpirationsMs;

    public String generateJwtToken(Authentication authentication){

        UserDetailsImplementation user = (UserDetailsImplementation) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationsMs))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameFromJwtToken(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException exception){
            logger.error("Invalid JWT signature: {}", exception.getMessage());
        } catch (MalformedJwtException exception){
            logger.error("Invalid JWT token: {}", exception.getMessage());
        } catch (ExpiredJwtException exception){
            logger.error("JWT token is expired: {}", exception.getMessage());
        } catch (UnsupportedJwtException exception){
            logger.error("JWT token is unsupported: {}", exception.getMessage());
        } catch (IllegalArgumentException exception){
            logger.error("JWT claims string is empty: {}", exception.getMessage());
        }

        return false;
    }
}
