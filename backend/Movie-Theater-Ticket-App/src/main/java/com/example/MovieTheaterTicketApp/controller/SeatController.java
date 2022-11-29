package com.example.MovieTheaterTicketApp.controller;
import com.example.MovieTheaterTicketApp.model.Seat;
import com.example.MovieTheaterTicketApp.service.SeatService;
import com.example.MovieTheaterTicketApp.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/seats")
public class SeatController {
    private final SeatService seatService;
    private final TicketService ticketService;
    @Autowired
    public SeatController(SeatService seatService, TicketService ticketService) {
        this.seatService = seatService;
        this.ticketService = ticketService;
    }

    @GetMapping()
    public List<Seat> getSeats(){
        // return list of all movies
        return seatService.getSeats();
    }

    @PostMapping()
    public void addSeat(@RequestBody Seat seat){
        // add movie to db
        seatService.addSeat(seat);
    }

    @DeleteMapping()
    public void removeSeat(@RequestBody Seat seat){
        // remove movie from db
        seatService.removeSeat(seat);
    }

    @PatchMapping()
    public void registerSeat(@RequestBody Seat seat){
        // set seat to taken
        seatService.registerSeat(seat);
    }

    @PostMapping(path = "seatId/{seatId}/TicketId/{ticketId}")
    public void selectMovieToView(@PathVariable("seatId") Long seatId,
                                @PathVariable("ticketId") Long ticketId){
        // choose a movie to view and update that info in the ticket
        ticketService.updateTicketMovie(ticketId, seatId);
    }
}
