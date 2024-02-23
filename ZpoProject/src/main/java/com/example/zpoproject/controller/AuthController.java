//package com.example.zpoproject.controller;
//
//import com.example.zpoproject.JwtUtils;
//import com.example.zpoproject.entity.JwtResponse;
//import com.example.zpoproject.entity.Owner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    private final JwtUtils jwtUtils;
//    private final ApplicationContext context;
//
//    @Autowired
//    public AuthController(@Lazy JwtUtils jwtUtils, ApplicationContext context) {
//        this.jwtUtils = jwtUtils;
//        this.context = context;
//    }
//
//    private AuthenticationManager getAuthenticationManager() {
//        return context.getBean(AuthenticationManager.class);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Owner loginRequest) {
//        Authentication authentication = getAuthenticationManager().authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateToken(authentication.getName());
//        return ResponseEntity.ok(new JwtResponse(jwt));
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout() {
//        SecurityContextHolder.getContext().setAuthentication(null);
//        return ResponseEntity.ok("Wylogowano pomyślnie");
//    }
//}
