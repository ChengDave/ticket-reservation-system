package com.example.MovieTheaterTicketApp.controller;
import com.example.MovieTheaterTicketApp.model.Seat;
import com.example.MovieTheaterTicketApp.model.Showtime;
import com.example.MovieTheaterTicketApp.service.SeatService;
import com.example.MovieTheaterTicketApp.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/seat")
@RestController
public class SeatController {
    private final SeatService seatService;
    private final TicketService ticketService;

    @Autowired
    public SeatController(SeatService seatService, TicketService ticketService) {
        this.seatService = seatService;
        this.ticketService = ticketService;
    }

    @GetMapping()
    public List<Seat> getSeatsByShowtime(@RequestBody Showtime show){
        // return list of all seats by showtime object
        return seatService.getSeatsByShowtime(show);
    }

    @GetMapping(path="/{showTimeId}")
    public List<Seat> getSeatsByShowtimeId(@PathVariable("showTimeId") Long showTimeId){
        // return list of all seats by ShowtimeId. If more than 10% taken and time is before public announcement then show all seats as taken
        return seatService.findByShowtime_id(showTimeId);
    }


    @GetMapping(path="/available/{showTimeId}")
    public List<Seat> getAvailableSeatsByShowtimeId(@PathVariable("showTimeId") Long showTimeId){
        // return list of all available seats by ShowtimeId.
        // If more than 10% taken and time is before public announcement then show all seats as taken
        return seatService.findByshowtime_idAndTAndTakenEqualsFalse(showTimeId);
    }

    @PostMapping()
    public void addSeat(@RequestBody Seat seat){
        // add seat database
        seatService.addSeat(seat);
    }

    @DeleteMapping()
    public void removeSeat(@RequestBody Seat seat){
        // remove seat from db
        seatService.removeSeat(seat);
    }

    @PatchMapping()
    public void registerSeat(@RequestBody Seat seat){
        // set seat to taken
        seatService.registerSeat(seat);
    }

}
