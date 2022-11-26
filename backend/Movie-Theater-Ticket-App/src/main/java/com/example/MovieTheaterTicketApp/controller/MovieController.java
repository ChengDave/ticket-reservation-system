package com.example.MovieTheaterTicketApp.controller;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.service.MovieService;
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
        // return list of all movies
        return movieService.getMovies();
    }

    @PostMapping()
    public void addMovie(@RequestBody Movie movie){
        // add movie to db
        movieService.addMovie(movie);
    }

    @DeleteMapping()
    public void removeMovie(@RequestBody Movie movie){
        // remove movie from db
        movieService.removeMovie(movie);
    }
}
