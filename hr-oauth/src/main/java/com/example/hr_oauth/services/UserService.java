package com.example.hr_oauth.services;

import com.example.hr_oauth.entities.User;
import com.example.hr_oauth.feing.UserFeing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserFeing userFeing;

    public User findByEmail(String email) {
        User user = userFeing.findByEmail(email).getBody();

        if (user == null) {
          throw new IllegalArgumentException();
        }

        return user;
    }
}
