package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.model.Showtime;
import com.example.MovieTheaterTicketApp.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;

    public ShowtimeService(ShowtimeRepository movieRepository) {
        this.showtimeRepository = movieRepository;
    }

    public List<Showtime> getShowtimes(){
        return (List<Showtime>) showtimeRepository.findAll();
    }

    public List<Showtime> getShowtimes(String movieTitle) {
        return (List<Showtime>) showtimeRepository.findByMovieTitle(movieTitle);
    }

    public void addShowtime(Showtime showtime) {
        //TODO: Need error handling if showtime is already taken
        showtimeRepository.save(showtime);
    }

    public void removeShowtime(Showtime showtime) {
        //TODO: Need error handling if showtime does not exist
        showtimeRepository.delete(showtime);
    }
}
