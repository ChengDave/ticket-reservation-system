package com.example.MovieTheaterTicketApp.repository;

import com.example.MovieTheaterTicketApp.model.Showtime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends CrudRepository<Showtime, Long>{
}
