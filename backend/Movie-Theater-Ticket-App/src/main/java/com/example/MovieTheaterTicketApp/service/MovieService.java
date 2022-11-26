package com.example.MovieTheaterTicketApp.service;

import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return (List<Movie>) movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        //TODO: Need error handling if movie name is already taken
        movieRepository.save(movie);
    }

    public void removeMovie(Movie movie) {
        //TODO: Need error handling if movie name does not exist
        movieRepository.save(movie);
    }
}
