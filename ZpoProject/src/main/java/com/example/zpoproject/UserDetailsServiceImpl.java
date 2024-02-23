//package com.example.zpoproject;
//
//import com.example.zpoproject.entity.Owner;
//import com.example.zpoproject.repository.OwnerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private OwnerRepository ownerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Owner owner = ownerRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika z emailem: " + email));
//
//        return new org.springframework.security.core.userdetails.User(owner.getEmail(), owner.getPassword(), new ArrayList<>());
//    }
//
//}
