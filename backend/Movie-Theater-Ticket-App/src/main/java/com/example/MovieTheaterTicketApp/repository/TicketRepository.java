package com.example.MovieTheaterTicketApp.repository;

import com.example.MovieTheaterTicketApp.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MovieTheaterTicketApp.model.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    Ticket getTicketBySeatId(Long id);

    List<Ticket> findByUser_id(Long id);

}
