package com.example.MovieTheaterTicketApp.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    public List<Ticket> findByUser_id(Long userId){
        return  ticketRepository.findByUser_id(userId);
    }

    public List<Ticket> findByUser_idToCancel(Long userId){
        List<Ticket> allTicketsforUser = ticketRepository.findByUser_id(userId);
        List<Ticket> allTicketsAvailableToCancel = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();

        for(Ticket t:allTicketsforUser){
            LocalDateTime showdate = t.getSeat().getShowtime().getLocalDateTime();
            //System.out.println(showdate.toString());
            if(showdate.minusDays(3).isAfter(today)){
                allTicketsAvailableToCancel.add(t);
            }
        }

        return allTicketsAvailableToCancel;
    }


    public void deleteAll(){
        ticketRepository.deleteAll();
    }



    
}
