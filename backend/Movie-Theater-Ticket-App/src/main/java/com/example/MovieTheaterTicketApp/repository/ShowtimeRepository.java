package com.example.MovieTheaterTicketApp.repository;

import com.example.MovieTheaterTicketApp.model.Showtime;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends CrudRepository<Showtime, Long>{

	// @Query("SELECT s.theater.theaterTitle, s.localDateTime FROM Showtime s WHERE s.movie = (SELECT id FROM Movie m WHERE m.movieTitle = ?1)")
	// @Query("select s.theaterId, s.local_date_time from Showtime s where s.movie = (SELECT id FROM Movie m WHERE m.movieTitle = ?1)")
	// public List<Showtime> findByMovieTitle(String movieTitle);
	public Optional<Showtime> findById(Long id);

	public List<Showtime> findShowtimeByMovie_MovieTitle(String movieTitle);
}
