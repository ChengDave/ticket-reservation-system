package com.example.MovieTheaterTicketApp.controller;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.model.Showtime;
import com.example.MovieTheaterTicketApp.service.ShowtimeService;
import com.example.MovieTheaterTicketApp.service.TheaterService;
import com.example.MovieTheaterTicketApp.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/showtime")
public class ShowtimeController {
    private final ShowtimeService showtimeService;
    private final TicketService ticketService;
    private final TheaterService theaterService;

    @Autowired
    public ShowtimeController(ShowtimeService showtimeService, 
                                TicketService ticketService,
                                TheaterService theaterService) {
        this.showtimeService = showtimeService;
        this.ticketService = ticketService;
        this.theaterService = theaterService;
    }

    @GetMapping()
    public List<Showtime> getShowtimes(){
        // return list of all movies
        return showtimeService.getShowtimes();
    }

    @GetMapping(value = "/MOVIE/{movieTitle}")
    public List<Showtime> getShowtimes(@PathVariable("movieTitle") String movieTitle) {
        
        return showtimeService.getShowtimes(movieTitle);
    }

    @PostMapping()
    public void addMovie(@RequestBody Showtime showtime){
        // add movie to db
        showtimeService.addShowtime(showtime);
    }

    @DeleteMapping()
    public void removeMovie(@RequestBody Showtime showtime){
        // remove movie from db
        showtimeService.removeShowtime(showtime);
    }

}
