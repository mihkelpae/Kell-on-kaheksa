package com.example.demo.services;


import com.example.demo.entities.UserPictures;
import com.example.demo.repositories.UserPicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Service
public class UserPicturesRepositoryService {

    @Autowired
    UserPicturesRepository userPicturesRepository;

    @Autowired
    UserService userService;



    public UserPictures storeFile(MultipartFile file, Principal principal) throws Exception{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String owner = userService.getUser(principal).getEmail();

        String fileExtentions = ".jpg,.jpeg,.png";
        int lastIndex = fileName.lastIndexOf(".");
        String fileType = fileName.substring(lastIndex, fileName.length());

        if (fileExtentions.contains(fileType)) {

            try {
                if (fileName.contains("..")) {
                    throw new Exception("asd");
                }

                UserPictures userPictures = new UserPictures(fileName, file.getContentType(), file.getBytes(), owner);
                return userPicturesRepository.save(userPictures);

            } catch (IOException ex) {
                throw new Exception("dsa");

            }
        }
        else {
            throw new Exception("dsa");
        }
    }

    /*public List<UserPictures> getFile(String email) {
        return userPicturesRepository.getByEmail(email);
    }*/
}
