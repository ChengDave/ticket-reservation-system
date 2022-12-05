package com.example.MovieTheaterTicketApp.controller;


import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.service.EmailService;
import com.example.MovieTheaterTicketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "api/v1/email")
public class EmailController {

    private EmailService emailService;
    private UserService userService;

    @Autowired
    public EmailController(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    @PostMapping(path = "userId/{userId}")
    public RegisteredUser emailUser(@PathVariable("userId") Long userId){
        // email the user
        if (userId == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment did not go through");
        }
        RegisteredUser user = userService.getUser(userId);
        
         emailService.emailReceiptAndTicket(user);
        return user;
    }

}

