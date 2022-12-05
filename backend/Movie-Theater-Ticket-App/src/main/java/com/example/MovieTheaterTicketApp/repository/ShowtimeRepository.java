package com.example.MovieTheaterTicketApp.repository;

import com.example.MovieTheaterTicketApp.model.Showtime;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends CrudRepository<Showtime, Long>{

	public Optional<Showtime> findById(Long id);
	public List<Showtime> findShowtimeByMovie_MovieTitle(String movieTitle);
}
