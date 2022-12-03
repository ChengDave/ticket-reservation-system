package com.example.MovieTheaterTicketApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieTheaterTicketApp.model.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    List<Ticket> findTicketsByUser_Id(Long id);
}
