//package com.example.zpoproject;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtils {
//
//    private static final String SECRET_KEY = "losowy-klucz";
//    private static final long EXPIRATION_TIME = 86400000; // 24 godziny
//
//    public String generateToken(String username) {
//        return JWT.create()
//                .withSubject(username)
//                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .sign(Algorithm.HMAC512(SECRET_KEY));
//    }
//
//    public String validateTokenAndRetrieveSubject(String token){
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(SECRET_KEY)).build();
//        try {
//            DecodedJWT jwt = verifier.verify(token);
//            return jwt.getSubject();
//        } catch (JWTVerificationException exception){
//            // JWT nieprawidłowy
//            return null;
//        }
//    }
//}
