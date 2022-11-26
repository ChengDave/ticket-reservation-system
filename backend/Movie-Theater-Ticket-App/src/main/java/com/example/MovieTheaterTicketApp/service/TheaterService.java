package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Theater;
import com.example.MovieTheaterTicketApp.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository movieRepository) {
        this.theaterRepository = movieRepository;
    }

    public List<Theater> getTheaters(){
        return (List<Theater>) theaterRepository.findAll();
    }

    public void addTheater(Theater theater) {
        //TODO: Need error handling if theater name is already taken
        theaterRepository.save(theater);
    }

    public void removeTheater(Theater theater) {
        //TODO: Need error handling if theater name does not exist
        theaterRepository.delete(theater);
    }
}
