package com.example.MovieTheaterTicketApp.repository;
import java.util.List;
import java.util.Optional;

import com.example.MovieTheaterTicketApp.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
    public Movie findByMovieTitle(String name);
    public List<Movie> findByMovieTitleStartsWith(String partialName);
    public Optional<Movie> findById(Long id);
}
