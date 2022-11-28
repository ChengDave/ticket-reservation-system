package com.example.MovieTheaterTicketApp.repository;

import com.example.MovieTheaterTicketApp.model.Showtime;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends CrudRepository<Showtime, Long>{

	@Query("Select s.theaterId s.local_date_time, s.from Showtime s where s.movie = (SELECT id FROM Movie m WHERE m.movieTitle = ?1)")
	public List<Showtime> findByMovieTitle(String movieTitle);
}
