package com.example.MovieTheaterTicketApp.controller;

import java.util.List;
import java.util.Optional;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.model.Seat;
import com.example.MovieTheaterTicketApp.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MovieTheaterTicketApp.model.Ticket;
import com.example.MovieTheaterTicketApp.service.TicketService;
import com.example.MovieTheaterTicketApp.service.UserService;

@RequestMapping("api/v1/ticket")
@RestController
public class TicketController {
    TicketService ticketService;
    SeatService seatService;
    UserService userService;

    @Autowired
    public TicketController(TicketService ticketService, SeatService seatService, UserService userService) {
        this.ticketService = ticketService;
        this.seatService = seatService;
        this.userService = userService;
    }
    
    @PostMapping(value = "/user/{userId}/seat/{seatId}")
    public void addTicket(@PathVariable("userId") int userId, @PathVariable("seatId") Long seatId){
        RegisteredUser user = userService.getUserById(userId);
        Seat seat = seatService.findById(seatId);
        
        // seatService.registerSeat(seat); // sets seat to istaken
        ticketService.addTicket(new Ticket(user, seat));
    }

//    @DeleteMapping
//    public void deleteTicket(@RequestBody Ticket ticket){
//        Seat seat = ticket.getSeat();
//        seatService.registerSeat(seat); // sets seat to istaken
//    }

    @DeleteMapping(path = "/{id}")
    public void deleteTicketById(@PathVariable("id") Long id){
        ticketService.deleteTicketById(id);
    }

    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping(path = "/{id}")
    public Optional<Ticket> getTicketById(@PathVariable("id") Long id){
       return ticketService.getTicketById(id);
    }
}

