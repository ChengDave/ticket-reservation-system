package com.example.MovieTheaterTicketApp.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ticketNo;
    String date;
    boolean receiptSent;
    boolean completed;
    Long movieId;
    Long showtimeId;
    Long theaterId;
    Long seatId;
    Long user;

    public Ticket(){
        super();
    }

    public Ticket(Long ticketNo, String date, Long user) {
        this.ticketNo = ticketNo;
        this.date = date;
        this.user = user;
    }

    public Long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isReceiptSent() {
        return receiptSent;
    }

    public void setReceiptSent(boolean receiptSent) {
        this.receiptSent = receiptSent;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    


}
