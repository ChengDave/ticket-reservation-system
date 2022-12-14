package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.model.Ticket;
import com.example.MovieTheaterTicketApp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getRegisteredUserMovies(){
        // return all movies
        return (List<Movie>) movieRepository.findAll();
    }

    public List<Movie> getRegisteredUserExclusiveMovies(){
        // return movies that have their public announcement after today
        List<Movie> movieList = (List<Movie>) movieRepository.findAll();
        List<Movie> prePublicAnnouncementMovies = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();

        for(Movie m:movieList){
            LocalDateTime publicAnnouncement = m.getPublicAnnouncement();
            if(!publicAnnouncement.isBefore(today)){
                prePublicAnnouncementMovies.add(m);
            }
        }

        return prePublicAnnouncementMovies;
    }

    public List<Movie> getGuestMovies(){
        // return movies that have their public announcement already past the date of today
        List<Movie> movieList = (List<Movie>) movieRepository.findAll();
        List<Movie> postPublicAnnouncementMovies = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();

        for(Movie m:movieList){
            LocalDateTime publicAnnouncement = m.getPublicAnnouncement();
            if(publicAnnouncement.isBefore(today)){
                postPublicAnnouncementMovies.add(m);
            }
        }

        return postPublicAnnouncementMovies;
    }

    public Movie selectToWatchMovie(Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie != null){
            return movie.get();
        }
        return null;
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void removeMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    public Movie getMovieByMovieTitle(String movieTitle){
        return movieRepository.findByMovieTitle(movieTitle);
    }

    public List<Movie> getMovieByPartialMovieTitle(String partialMovieTitle){
        return movieRepository.findByMovieTitleStartsWith(partialMovieTitle);
    }
}
