package com.abbey.api.authenticator;

import com.abbey.api.models.authentication.AuthenticationData;
import com.abbey.api.models.authentication.AuthenticationFeedback;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;

@Component
public class Authenticator {

    private Logger logger = LoggerFactory.getLogger(Authenticator.class);

    private static Authenticator instance;

    private SignatureAlgorithm algorithm;
    private SecretKey key;

    private Authenticator(){
        this.algorithm = SignatureAlgorithm.HS256;
        this.key = Keys.secretKeyFor(algorithm);
    }

    public static synchronized Authenticator getInstance () {
        if( instance == null){
            instance = new Authenticator();
        }
        return instance;
    }

    public AuthenticationFeedback createToken (Map<String, String> tokenData) {

        logger.info("CREATING TOKEN");

        AuthenticationFeedback feedback = AuthenticationFeedback.builder().build();

        Map<String, Object> data = new HashMap<>();
        data.put("data", tokenData);

        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        date.add(Calendar.HOUR, 24);

        Date expirationDate = date.getTime();

        String jws = Jwts.builder()
                .setClaims(data)
                .setExpiration(expirationDate)
                .signWith(this.key, this.algorithm)
                .compact();

        feedback.addData("token", jws);

        return feedback;
    }

    public AuthenticationFeedback validateToken (AuthenticationData data){

        logger.info("VALIDATING TOKEN");

        AuthenticationFeedback feedback = AuthenticationFeedback.builder().build();

        Jws<Claims> jws;

        try {
            jws = Jwts.parser()
                    .setSigningKey(this.key)
                    .parseClaimsJws(data.getToken());

            if(jws.getBody().getExpiration().before(new Date())){
                feedback.setSuccessful(false);
                feedback.setMessage("Something went wrong");

                throw new JwtException("The token has been expired");
            }
            else {
                feedback.setSuccessful(true);
                feedback.setMessage("Authentication was successful");
            }

        } catch (JwtException ex) {
            feedback.setMessage("Something went wrong.");
            feedback.setSuccessful(false);

            logger.error("VALIDATING TOKEN FAILED: "+ex);
        }

        return feedback;
    }

    public HashMap<String, String> getTokenData (AuthenticationData data){

        logger.info("GET TOKEN DATA");

        HashMap<String, String> tokenData = new HashMap<>();

        Jws<Claims> jws;

        try {
            jws = Jwts.parser()
                    .setSigningKey(this.key)
                    .parseClaimsJws(data.getToken());

            if(jws.getBody().getExpiration().before(new Date())){

                throw new JwtException("The token was expired");
            } else {
                ObjectMapper objectMapper = new ObjectMapper();

                HashMap claimsMap = jws.getBody().get("data", HashMap.class);

                String userId = String.valueOf(claimsMap.get("user"));
                String venueId = String.valueOf(claimsMap.get("venue"));

                tokenData.put("user", userId);
                tokenData.put("venue", venueId);
            }

        } catch (JwtException ex) {
            logger.error("VALIDATING TOKEN FAILED: "+ex);
        }

        return tokenData;
    }
}
