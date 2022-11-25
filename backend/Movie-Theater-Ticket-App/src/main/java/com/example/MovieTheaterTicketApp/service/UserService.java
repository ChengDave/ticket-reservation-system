package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers(){
        return List.of(new RegisteredUser("Kim", "Bauer","test3@gmail.com",true));
    }
}
