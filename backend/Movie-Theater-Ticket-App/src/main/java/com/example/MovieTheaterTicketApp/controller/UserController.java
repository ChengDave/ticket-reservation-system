package com.example.MovieTheaterTicketApp.controller;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<RegisteredUser> getUsers(){
        // return list of all registered users
        return userService.getUsers();
    }

    @GetMapping(value = "/USERNAME/{username}/PASSWORD/{password}")
    public String checkCredentials(@PathVariable("username") String username, @PathVariable("password") String password) {

        
        // TODO: Check if these credentials are valid for any of the registered users
        System.out.println("Username " + username + ", password " + password);
        return "Valid or Not as JSON";
    }

    @PostMapping(path = "/registeredUser")
    public void registerUser(@RequestBody RegisteredUser user) { 
        // TODO: Deal with this input to make a new Registered User
        userService.register(user);
    }

    @GetMapping(value = "email/{email}")
    public List<RegisteredUser> getUserByEmail(@PathVariable("email") String email){
        if (email == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        return userService.getUserByEmail(email);
    }

    @PostMapping(path = "/guestUser")
    public void guestUser(@RequestBody RegisteredUser user) { 
        // TODO: Deal with this input to make a new guest User
        user.setRegistered(false);
        userService.register(user);
    }

  
}
