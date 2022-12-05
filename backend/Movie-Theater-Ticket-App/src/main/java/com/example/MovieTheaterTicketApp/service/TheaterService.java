package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Theater;
import com.example.MovieTheaterTicketApp.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository movieRepository) {
        this.theaterRepository = movieRepository;
    }

    public List<Theater> getTheaters(){
        return (List<Theater>) theaterRepository.findAll();
    }

    public Theater getTheater(Long id){
        Optional<Theater> theater = theaterRepository.findById(id);
        if (theater != null){
            return theater.get();
        }
        return null;
    }

    public void addTheater(Theater theater) {
        theaterRepository.save(theater);
    }

    public void removeTheater(Theater theater) {
        theaterRepository.delete(theater);
    }
}
