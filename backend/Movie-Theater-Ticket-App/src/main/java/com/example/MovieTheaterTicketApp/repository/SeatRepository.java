package com.example.MovieTheaterTicketApp.repository;

import com.example.MovieTheaterTicketApp.model.Seat;
import com.example.MovieTheaterTicketApp.model.Showtime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Long>{
    List<Seat> findByShowtime(Showtime show);
    List<Seat> findByshowtime_id(Long id);
    @Query("SELECT s FROM Seat s WHERE s.isTaken = false AND s.showtime.id=?1")
    List<Seat> findByShowtime_idAndTAndIsTakenEqualsFalse(Long id);

    Seat findSeatById(Long id);


}
