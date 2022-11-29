package com.example.MovieTheaterTicketApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieTheaterTicketApp.model.Ticket;
import com.example.MovieTheaterTicketApp.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }

    public void deleteAll(){
        ticketRepository.deleteAll();
    }

    public void updateTicketMovie(Long ticketId, Long movieId){
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket != null){
            ticket.get().setMovieId(movieId);
        }
    }

    public void updateTicketShowtime(Long ticketId, Long showtimeId){
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket != null){
            ticket.get().setMovieId(showtimeId);
        }
    }

    public void updateTicketTheaterId(Long ticketId, Long theaterId){
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket != null){
            ticket.get().setMovieId(theaterId);
        }
    }

    public void updateTicketSeatId(Long ticketId, Long seatId){
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket != null){
            ticket.get().setMovieId(seatId);
        }
    }

    
}
