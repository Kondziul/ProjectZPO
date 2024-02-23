//package com.example.zpoproject;
//
//import com.example.zpoproject.entity.Owner;
//import com.example.zpoproject.repository.OwnerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.util.ArrayList;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtUtils jwtUtils;
//
//    private final OwnerRepository ownerRepository;
//
//    @Autowired
//    public SecurityConfig(JwtUtils jwtUtils, OwnerRepository ownerRepository) {
//        this.jwtUtils = jwtUtils;
//        this.ownerRepository = ownerRepository;
//    }
//
//    // Definicja SecurityFilterChain
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/api/auth/**").permitAll() // Pozwala każdemu na dostęp do ścieżek zaczynających się od /api/auth
//                        .anyRequest().authenticated() // Wymaga uwierzytelnienia dla wszystkich innych żądań
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login") // Określa stronę logowania
//                        .permitAll() // Pozwala każdemu na dostęp do strony logowania
//                )
//                .addFilterBefore(new JwtTokenFilter(jwtUtils), UsernamePasswordAuthenticationFilter.class); // Dodaje JwtTokenFilter do łańcucha filtrów
//
//        // Jeśli chcesz wyłączyć CSRF (niezalecane):
//        // http.csrf().disable();
//
//        return http.build();
//    }
//
//    // Definicja UserDetailsService
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            Owner owner = ownerRepository.findByEmail(username)
//                    .orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika: " + username));
//            // Tworzy UserDetails na podstawie danych użytkownika z bazy danych
//            return new User(owner.getEmail(), owner.getPassword(), new ArrayList<>());
//        };
//    }
//
//    // Definicja PasswordEncodera
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Używa BCryptPasswordEncoder do hashowania haseł
//    }
//
//    // Konfiguracja globalna
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService()) // Ustawia niestandardową obsługę szczegółów użytkownika
//                .passwordEncoder(passwordEncoder()); // Ustawia enkoder hasła
//    }
//
//    // Definicja bean'a AuthenticationManager
//    @Bean
//    public AuthenticationManager authenticationManagerBean(AuthenticationManagerBuilder auth) throws Exception {
//        return auth.build();
//    }
//}
//
