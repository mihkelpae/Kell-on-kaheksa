package com.example.demo.controllers;

import com.example.demo.repositories.UserPicturesRepository;
import com.example.demo.services.UserPicturesRepositoryService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
public class ProfilePictureUploadController {

    @Autowired
    UserPicturesRepository userPicturesRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserPicturesRepositoryService userPicturesRepositoryService;

    @RequestMapping(value="/uploadProfilePic", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file")MultipartFile file ,
                             Principal principal, Model model) throws Exception{
        try {
            userPicturesRepositoryService.storeFile(file, principal);
            return "redirect:/profile";
        }
        catch (Exception e) {
            model.addAttribute("fileUploadError", true);
            return "redirect:/uploadError";
        }
    }
}
