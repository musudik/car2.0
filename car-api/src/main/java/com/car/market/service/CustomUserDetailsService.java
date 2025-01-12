package com.car.market.service;

import com.car.market.entity.User;
import com.car.market.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        if(user.isPresent()) {
            UserDetails userDetails =
                    org.springframework.security.core.userdetails.User.builder()
                            .username(user.get().getEmail())
                            .password(user.get().getPassword())
                            .roles(roles.toArray(new String[0]))
                            .build();
            return userDetails;
        } else {
            throw new UsernameNotFoundException("No user found with the email: "+email);
        }
    }
}