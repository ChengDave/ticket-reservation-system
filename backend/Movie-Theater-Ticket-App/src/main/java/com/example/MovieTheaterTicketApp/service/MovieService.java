package com.example.MovieTheaterTicketApp.service;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final UserRepository movieRepository;

    public MovieService(UserRepository userRepository) {
        this.movieRepository = userRepository;
    }

    public List<RegisteredUser> getUsers(){
        return (List<RegisteredUser>) movieRepository.findAll();
    }

    public void register(RegisteredUser registerUser) {
        //TODO: Need error handling if movie name is already taken
        movieRepository.save(registerUser);
    }
}
