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

    public boolean deleteTicket(Ticket ticket){
        //returns false if ticket does not exist. If exists then deletes ticket and returns true
        if (!ticketRepository.existsById(ticket.getTicketNo()))
        {
            return false;
        }

        ticketRepository.delete(ticket);
        return true;

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
            if(showdate.minusDays(3).isAfter(today)){
                allTicketsAvailableToCancel.add(t);
            }
        }

        return allTicketsAvailableToCancel;
    }


    public void deleteAll(){
        ticketRepository.deleteAll();
    }

	public List<Ticket> getTicketByUser(Long id) {
		return ticketRepository.findByUser_id(id);
	}



    
}
