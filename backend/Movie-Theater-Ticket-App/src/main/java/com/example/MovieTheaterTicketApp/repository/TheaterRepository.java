package com.example.MovieTheaterTicketApp.repository;
import com.example.MovieTheaterTicketApp.model.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends CrudRepository<Theater, Long>{
}
