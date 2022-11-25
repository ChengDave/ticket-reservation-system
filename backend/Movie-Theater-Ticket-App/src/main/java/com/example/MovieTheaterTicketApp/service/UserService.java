package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.model.User;
import com.example.MovieTheaterTicketApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<RegisteredUser> getUsers(){
        return (List<RegisteredUser>) userRepository.findAll();
    }

    public void register(RegisteredUser registerUser) {
        //TODO: Need error handling if user email is already taken
        userRepository.save(registerUser);
    }
}
