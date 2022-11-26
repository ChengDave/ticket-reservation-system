package com.example.MovieTheaterTicketApp.controller;

import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.service.MovieService;
import com.example.MovieTheaterTicketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/movies")
public class MovieController {
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<Movie> getMovies(){
        // return list of all registered users
        return movieService.getMovies();
    }

    @PostMapping()
    public void addMovie(@RequestBody Movie movie){
        // register student
        movieService.addMovie(movie);
    }
}
