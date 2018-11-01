package com.example.demo.services;


import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.Map;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public User userInfo(Principal principal) {

        Map<String, Object> details = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();

        String uid = (String)details.get("sub");
        String firstName = (String)details.get("given_name");
        String lastName = (String)details.get("family_name");
        String name = (String)details.get("name");
        String email = (String)details.get("email");

        User user = userRepository.findByEmail(email);

        if(user == null) {
            user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setGoogleUid(uid);
            userRepository.save(user);
        }

        return user;
    }
}
