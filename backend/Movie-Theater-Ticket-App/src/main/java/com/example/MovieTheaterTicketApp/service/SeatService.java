package com.example.MovieTheaterTicketApp.service;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.model.Seat;
import com.example.MovieTheaterTicketApp.model.Showtime;
import com.example.MovieTheaterTicketApp.repository.MovieRepository;
import com.example.MovieTheaterTicketApp.repository.SeatRepository;
import com.example.MovieTheaterTicketApp.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final ShowtimeRepository showtimeRepository;


    public SeatService(SeatRepository seatRepository,ShowtimeRepository showtimeRepository) {
        this.seatRepository = seatRepository;
        this.showtimeRepository = showtimeRepository;
    }

    public List<Seat> getSeats(){
        return (List<Seat>) seatRepository.findAll();
    }

    public List<Seat> getSeatsByShowtime(Showtime show){
        return seatRepository.findByShowtime(show);
    }

    public List<Seat> findByShowtime_id(Long id){
        // show seats if after public announce or if under 10% taken. Else show all seats as taken if before announcement
        // and 10% or more taken
        Optional<Showtime> showtime = showtimeRepository.findById(id);

        LocalDateTime publicAnnouncement = showtime.get().getMovie().getPublicAnnouncement();
        LocalDateTime today = LocalDateTime.now();

        if(publicAnnouncement.isBefore(today)){
            // if public announcement has already past then early return to show all seats available
            return seatRepository.findByshowtime_id(id);
        }

        List<Seat> allSeats = seatRepository.findByshowtime_id(id);
        List<Seat> availableSeats = seatRepository.findByShowtime_idAndTAndIsTakenEqualsFalse(id);

        if(availableSeats.size()/allSeats.size()<=0.9){
            // if number of taken seats is greater than 10% then return empty list
            for(Seat s: allSeats){
                s.setTaken(true);
            }
            return allSeats;
        }

        return seatRepository.findByshowtime_id(id); // show all seats if less than 10% taken

    }

    public List<Seat> findByshowtime_idAndTAndTakenEqualsFalse(Long id){
        // return all available seats if after public announce, else allow seats to be shown if under 10% are taken
        Optional<Showtime> showtime = showtimeRepository.findById(id);

        LocalDateTime publicAnnouncement = showtime.get().getMovie().getPublicAnnouncement();
        LocalDateTime today = LocalDateTime.now();

        if(publicAnnouncement.isBefore(today)){
            // if public announcement has already past then early return to show all seats available
            return seatRepository.findByShowtime_idAndTAndIsTakenEqualsFalse(id);
        }

        List<Seat> allSeats = seatRepository.findByshowtime_id(id);
        List<Seat> availableSeats = seatRepository.findByShowtime_idAndTAndIsTakenEqualsFalse(id);

        if(availableSeats.size()/allSeats.size()<=0.9){
            // if number of taken seats is greater than 10% then return empty list
            return new ArrayList<Seat>();
        }

        return seatRepository.findByShowtime_idAndTAndIsTakenEqualsFalse(id);
    }

    public Seat findById(Long id){
        return seatRepository.findSeatById(id);
    }


    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    public void removeSeat(Seat seat) {
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
