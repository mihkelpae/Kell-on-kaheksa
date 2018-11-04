package com.example.demo.controllerAdvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(value= MultipartException.class)
    public String handleTooLargeFile(MultipartException mpex,
                                     HttpServletRequest request) {

        return "redirect:/uploadError";
    }
}
