package com.example.MovieTheaterTicketApp.controller;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/users")
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

    @PostMapping()
    public void registerUser(@RequestBody String request) { //RegisteredUser registerUser){

        // TODO: Deal with this input to make a new Registered User
        System.out.println(request);

        //  userService.register(registerUser);
    }
}
