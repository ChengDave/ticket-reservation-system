package com.example.MovieTheaterTicketApp.repository;
import java.util.List;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<RegisteredUser, Long>{
}
