package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.internet.MimeMessage;

@Controller
public class IndexController {


    @Autowired
    private JavaMailSender sender;

    @RequestMapping(value="/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public String send(@RequestParam("mail") String mail) {
        try {
            sendEmail(mail);
            System.out.println("Email sent!");
            return "index";
        } catch (Exception e) {
            return "Error while sending email: " + e;
        }
    }

    private void sendEmail(String recipent) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(recipent);
        helper.setText("This is an automated email from kellon8");
        helper.setSubject("Hi");

        sender.send(message);
    }
}