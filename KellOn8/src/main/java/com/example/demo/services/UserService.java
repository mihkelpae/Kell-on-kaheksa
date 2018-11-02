package com.example.demo.services;


import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User updateUserStatus(Principal principal) {
        OAuth2Authentication auth2Authentication = (OAuth2Authentication) principal;
        Map<String, Object> details = (Map<String, Object>) auth2Authentication.getUserAuthentication().getDetails();

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
            user.setUid(uid);
            userRepository.save(user);
        }

        return user;
    }

    public User getUser(Principal principal) {
        if(principal == null) {
            return null;
        }
        OAuth2Authentication auth2Authentication = (OAuth2Authentication) principal;
        Map<String, Object> details = (Map<String, Object>) auth2Authentication.getUserAuthentication().getDetails();

        User user = userRepository.findByEmail((String)details.get("email"));

        if(user == null) {
            return updateUserStatus(principal);
        }

        return user;
    }
}
