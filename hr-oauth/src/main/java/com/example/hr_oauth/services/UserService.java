package com.example.hr_oauth.services;

import com.example.hr_oauth.entities.User;
import com.example.hr_oauth.feing.UserFeing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeing userFeing;

    public User findByEmail(String email) {
        User user = userFeing.findByEmail(email).getBody();

        if (user == null) {
          throw new IllegalArgumentException("User not found");
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeing.findByEmail(email).getBody();

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
