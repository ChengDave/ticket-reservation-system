package com.example.MovieTheaterTicketApp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addPayment(@RequestBody Ticket ticket){
        
        //generate date and time and add to the created ticket object
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ticket.setDate(dtf.format(now).substring(0,10));
        ticketService.addTicket(ticket);
    }
    
    // @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    // @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping(path = "{id}")
    public Ticket getTicketById(@PathVariable("id") Long id){
 
        if (!ticketService.getTicketById(id).isEmpty()){
            Ticket t = ticketService.getTicketById(id).get();
            return t;
        }
        else{return null;}
    }


    
}

