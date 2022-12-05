package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.model.Showtime;
import com.example.MovieTheaterTicketApp.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return (List<Showtime>) showtimeRepository.findShowtimeByMovie_MovieTitle(movieTitle);
    }

    public Showtime getShowtime(Long id){
        Optional<Showtime> showtime = showtimeRepository.findById(id);
        if (showtime != null){
            return showtime.get();
        }
        return null;
    }

    public void addShowtime(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    public void removeShowtime(Showtime showtime) {
        showtimeRepository.delete(showtime);
    }
}
