package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Seat;
import com.example.MovieTheaterTicketApp.model.Showtime;
import com.example.MovieTheaterTicketApp.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeats(){
        return (List<Seat>) seatRepository.findAll();
    }

    public List<Seat> getSeatsByShowtime(Showtime show){
        return seatRepository.findByShowtime(show);
    }

    public List<Seat> findByShowtime_id(Long id){
        return seatRepository.findByshowtime_id(id);
    }

    public List<Seat> findByshowtime_idAndTAndTakenEqualsFalse(Long id){
        return seatRepository.findByShowtime_idAndTAndIsTakenEqualsFalse(id);
    }

    public Seat findById(Long id){
        return seatRepository.findSeatById(id);
    }


    public void addSeat(Seat seat) {
        //TODO: Need error handling if movie name is already taken
        seatRepository.save(seat);
    }

    public void removeSeat(Seat seat) {
        //TODO: Need error handling if movie name does not exist
        seatRepository.delete(seat);
    }
    public void registerSeat(Seat seat) {
        seat.setTaken(true);
        seatRepository.save(seat);
    }

    public void unregisterSeat(Seat seat) {
        seat.setTaken(false);
        seatRepository.save(seat);
    }
}
