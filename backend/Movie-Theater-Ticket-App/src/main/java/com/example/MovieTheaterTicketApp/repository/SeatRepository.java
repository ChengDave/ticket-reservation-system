package com.example.MovieTheaterTicketApp.repository;

import com.example.MovieTheaterTicketApp.model.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Long>{
}
