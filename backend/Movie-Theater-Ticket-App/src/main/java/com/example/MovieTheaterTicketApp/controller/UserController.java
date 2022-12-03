package com.example.MovieTheaterTicketApp.controller;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class  UserController {

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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/registeredUser")
    public void registerUser(@RequestBody RegisteredUser user) { 

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        user.setRegistrationDate(dtf.format(now));
        user.setNextPaymentDue(dtf.format(now));

        userService.register(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/guestUser")
    public void guestUser(@RequestBody RegisteredUser user) { 
        user.setRegistered(false);
        userService.register(user);
    }

    @GetMapping(value = "email/{email}")
    public List<RegisteredUser> getUserByEmail(@PathVariable("email") String email){
        if (email == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
        return userService.getUserByEmail(email);
    }



  
}
