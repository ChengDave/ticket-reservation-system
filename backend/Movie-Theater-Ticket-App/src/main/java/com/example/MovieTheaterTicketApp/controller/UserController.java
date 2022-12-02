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

    @GetMapping(value = "/ID/{id}")
    public RegisteredUser getUserById(@PathVariable("id") int id) {
        System.out.println("Here");
        return userService.getUserById(id);
    }

    @GetMapping(value = "/USERNAME/{username}/PASSWORD/{password}")
    public RegisteredUser checkCredentials(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.checkCredentials(username, password);
        // RegisteredUser user = userService.checkCredentials(username, password);
        // return user;
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
