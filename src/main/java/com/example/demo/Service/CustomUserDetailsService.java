package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Reposotory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}














// 1
//package com.example.demo.Service;
//
//import org.springframework.security.core.userdetails.*;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        // Dummy user (replace with DB logic)
//        if ("admin".equals(username)) {
//            return new User("admin", "$2a$10$Dow1sF6Z0p6wK8ZxF1hMCOkFqzG1xX7U5KkV6k6M6hV7hQyZ2j9lK",
//                    Collections.emptyList());
//        }
//
//        throw new UsernameNotFoundException("User not found");
//    }
//}










//  2
//package com.example.demo.Service;
//
//import org.springframework.security.core.userdetails.*;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        // 🔥 ADMIN USER
//        if ("admin".equals(username)) {
//            return new org.springframework.security.core.userdetails.User(
//                    "admin",
//                    "$2a$10$Dow1sF6Z0p6wK8ZxF1hMCOkFqzG1xX7U5KkV6k6M6hV7hQyZ2j9lK",
//                    List.of(
//                            new SimpleGrantedAuthority("ROLE_ADMIN")
//                    )
//            );
//        }
//
//        // 🔥 NORMAL USER
//        if ("user".equals(username)) {
//            return new org.springframework.security.core.userdetails.User(
//                    "user",
//                    "$2a$10$Dow1sF6Z0p6wK8ZxF1hMCOkFqzG1xX7U5KkV6k6M6hV7hQyZ2j9lK",
//                    List.of(
//                            new SimpleGrantedAuthority("ROLE_USER")
//                    )
//            );
//        }
//
//        throw new UsernameNotFoundException("User not found");
//    }
//}




