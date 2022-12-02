package com.example.MovieTheaterTicketApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MovieTheaterTicketApp.model.Ticket;
import com.example.MovieTheaterTicketApp.service.TicketService;

@RequestMapping("api/v1/ticket")
@RestController
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
    @PostMapping
    public void addTicket(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
    }

    @DeleteMapping
    public void deleteTicketById(@RequestBody Long id){
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

