package com.example.MovieTheaterTicketApp.controller;

import com.example.MovieTheaterTicketApp.model.GuestUser;
import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.model.User;
import com.example.MovieTheaterTicketApp.service.EmailService;
import com.example.MovieTheaterTicketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/users")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping()
    public void emailUser(@RequestBody User user, String email){
        // email the user

         emailService.emailReceiptAndTicket(user,email);
    }


    @PostMapping()
    public void emailAllRegUsers(String news){
        // email all users
        emailService.emailAllRegUsers(news);
    }
}
