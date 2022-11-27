package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Seat;
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

    public void addSeat(Seat seat) {
        //TODO: Need error handling if movie name is already taken
        seatRepository.save(seat);
    }

    public void removeSeat(Seat seat) {
        //TODO: Need error handling if movie name does not exist
        seatRepository.delete(seat);
    }

    public void registerSeat(Seat seat) {
        //TODO: Need error handling if movie name does not exist
        Seat userSeat = seatRepository.findById(seat.getId()).get();

        if (userSeat.isTaken()==true){
            // if seat already taken then return and don't update
            // TODO: figure out how to send message back to client that seat could not be updated for user
            return;
        }
        userSeat.setTaken(true);
        seatRepository.save(userSeat);
    }

}
