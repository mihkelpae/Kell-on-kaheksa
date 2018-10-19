package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.internet.MimeMessage;

@Controller
public class IndexController {

    @Autowired
    public JavaMailSender sender;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }

    @RequestMapping(value="/mailSent", method = RequestMethod.POST)
    public String sendMail(@RequestParam String address) {

        try {
            sendEmail(address);
            System.out.println("Email sent!");
            return "redirect:/";
        } catch (Exception e) {
            return "Error while sending email: " + e;
        }
    }

    private void sendEmail(String recipient) throws Exception{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject("Mail from KellOn8");
        message.setText("Hi. This is an automatic email from kellon8.");
        sender.send(message);
    }
}