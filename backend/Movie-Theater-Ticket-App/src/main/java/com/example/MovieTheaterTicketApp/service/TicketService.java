package com.example.MovieTheaterTicketApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.MovieTheaterTicketApp.model.Ticket;
import com.example.MovieTheaterTicketApp.repository.TicketRepository;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void deleteTicketById(Long id){
        ticketRepository.deleteById(id);
    }
    public void deleteTicket(Ticket ticket){
        ticketRepository.delete(ticket);
    }

    public Ticket getTicketBySeatId(Long seatId){
        return ticketRepository.getTicketBySeatId(seatId);
    }


    public void deleteAll(){
        ticketRepository.deleteAll();
    }



    
}
