package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }

    /*try {
        sendEmail("email");
        System.out.println("Email sent!");
        return "redirect:/";
    } catch (Exception e) {
        return "Error while sending email: " + e;
    }

    private void sendEmail(String recipient) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(recipient);
        helper.setText("This is an automated email from kellon8");
        helper.setSubject("Hi");

        sender.send(message);
    }*/


}