package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return (List<Movie>) movieRepository.findAll();
    }

    public Movie selectToWatchMovie(Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie != null){
            return movie.get();
        }
        return null;
    }

    public void addMovie(Movie movie) {
        //TODO: Need error handling if movie name is already taken
        movieRepository.save(movie);
    }

    public void removeMovie(Movie movie) {
        //TODO: Need error handling if movie name does not exist
        movieRepository.delete(movie);
    }

    public Movie getMovieByMovieTitle(String movieTitle){
        return movieRepository.findByMovieTitle(movieTitle);
    }

    public List<Movie> getMovieByPartialMovieTitle(String partialMovieTitle){
        return movieRepository.findByMovieTitleStartsWith(partialMovieTitle);
    }
}
