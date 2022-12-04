package com.example.MovieTheaterTicketApp.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.model.Seat;
import com.example.MovieTheaterTicketApp.service.EmailService;
import com.example.MovieTheaterTicketApp.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    EmailService emailService;

    @Autowired
    public TicketController(TicketService ticketService, SeatService seatService, 
                            UserService userService,
                            EmailService emailService) {
        this.ticketService = ticketService;
        this.seatService = seatService;
        this.userService = userService;
        this.emailService = emailService;
    }
    
    @PostMapping(value = "/user/{userId}/seat/{seatId}")
    public Ticket addTicket(@PathVariable("userId") int userId, @PathVariable("seatId") Long seatId){
        RegisteredUser user = userService.getUserById(userId);
        Seat seat = seatService.findById(seatId);
        seatService.registerSeat(seat); // sets seat to taken
        Ticket ticket = new Ticket(user, seat);
        ticketService.addTicket(ticket);

        // invoke the email service
        CompletableFuture.runAsync(() -> emailService.emailTicket(user, ticket.emailText()));
        return ticket;
    }

//    @DeleteMapping
//    public void deleteTicket(@RequestBody Ticket ticket){
//        Seat seat = ticket.getSeat();
//        seatService.registerSeat(seat); // sets seat to istaken
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/user/{userId}/seat/{seatId}")
    public ResponseEntity<String> deleteTicket(@PathVariable("userId") int userId, @PathVariable("seatId") Long seatId){
//        RegisteredUser user = userService.getUserById(userId);
        Ticket ticket = ticketService.getTicketBySeatId(seatId);
        Seat seat = seatService.findById(seatId);

        if (ticket==null || seat==null || !ticketService.deleteTicket(ticket)){
            //delete failed due to ticket not existing, early return
            return new ResponseEntity<>("FAILURE", HttpStatus.CONFLICT);
        }

        //successful delete, set seat to not taken
        seatService.unregisterSeat(seat); // sets seat to not taken
        return  new ResponseEntity<>("SUCCESS", HttpStatus.ACCEPTED);
    }

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

    @GetMapping(path = "/user/{id}")
    public List<Ticket> findByUser_id(@PathVariable("id") Long id){
        return ticketService.findByUser_id(id);
    }

    @GetMapping(path = "/usercancel/{id}")
    public List<Ticket> findByUser_idtoCancel(@PathVariable("id") Long id){
        return ticketService.findByUser_idToCancel(id);
    }

}