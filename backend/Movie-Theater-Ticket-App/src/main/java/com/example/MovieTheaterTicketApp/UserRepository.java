package com.example.MovieTheaterTicketApp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<RegisteredUser, Long> {
    List<RegisteredUser> findByLastName(String lastName);
    RegisteredUser findById(long id);
    }

