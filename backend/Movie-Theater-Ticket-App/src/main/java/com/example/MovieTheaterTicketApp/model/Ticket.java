package com.example.MovieTheaterTicketApp.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ticketNo;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="userId")
    private RegisteredUser user;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="showtimeId")
    private Seat seat;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNo=" + ticketNo +
                ", user=" + user +
                ", seat=" + seat +
                '}';
    }

    public String emailText(){
        String text = "TicketNo: " + ticketNo + "\n" + 
                    "Ticket Holder: " + user.getFirstName() + user.getLastName() + "\n" +
                    "Movie Name: " + seat.getShowtime().getMovie().getMovieTitle() + "\n" +
                    "Theatre: " + seat.getShowtime().getTheater().getTheaterTitle() + "\n" +
                    "Time: " + seat.getShowtime().getLocalDateTime() + "\n" +
                    "Seat Number: " + seat.getSeatNumber() + "\n";
        return text;
    }

    public Ticket(RegisteredUser user, Seat seat) {
        this.user = user;
        this.seat = seat;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    

    public Ticket(){
    }

    public Long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Long ticketNo) {
        this.ticketNo = ticketNo;
    }

}
