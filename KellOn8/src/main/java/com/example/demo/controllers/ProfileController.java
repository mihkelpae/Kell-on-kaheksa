package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserPicturesRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserPicturesRepositoryService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserPicturesRepository userPicturesRepository;

    @Autowired
    UserPicturesRepositoryService userPicturesRepositoryService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        String email = userService.getUser(principal).getEmail();

        model.addAttribute("user", new User());
        try {
            if (userPicturesRepository.getByEmail(email) != null) {
                byte[] array = userPicturesRepository.getByEmail(email);
                String base64 = "data:" + userPicturesRepository.getTypeByEmail(email) + ";base64, " + Base64Utils.encodeToString(array);
                model.addAttribute("picture", base64);
            } else {
                model.addAttribute("picture", userPicturesRepository.getByEmail(email));
            }
        }
        catch (Exception e) {
            return "redirect:/profile";
        }
        return "profile";
    }

    @RequestMapping(value="/saveProfileAddress", method = RequestMethod.POST)
    public String saveAddress(@RequestParam("address")String address,
                              Principal principal) {
        User test = userService.getUser(principal);
        String email = test.getEmail();
        userRepository.updateAddress(address, email);
        return "profile";
    }

    @RequestMapping(value="/deleteProfilePic", method=RequestMethod.POST)
    public String deletePic(Principal principal) {
        userPicturesRepository.deleteProfilePic(userService.getUser(principal).getEmail());
        return "redirect:/profile";
    }

    @RequestMapping(value = "/uploadError", method = RequestMethod.GET)
    public String uploadError(Model model, Principal principal) {
        String email = userService.getUser(principal).getEmail();
        model.addAttribute("user", new User());
        try {
            if (userPicturesRepository.getByEmail(email) != null) {
                byte[] array = userPicturesRepository.getByEmail(email);
                String base64 = "data:" + userPicturesRepository.getTypeByEmail(email) + ";base64, " + Base64Utils.encodeToString(array);
                model.addAttribute("picture", base64);
            } else {
                model.addAttribute("picture", userPicturesRepository.getByEmail(email));
            }
        }
        catch (Exception e) {
            return "redirect:/profile";
        }
        model.addAttribute("fileUploadError", true);
        return "profile";
    }
}