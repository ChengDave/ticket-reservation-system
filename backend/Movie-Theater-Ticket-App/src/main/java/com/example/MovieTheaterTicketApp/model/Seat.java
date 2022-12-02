package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

@Entity(name = "Seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "isTaken"
    )
    private boolean isTaken;

    @Column(
            name = "price"
    )
    private double price;

    @Column(
            name = "seatNumber"
    )
    private int seatNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="showtimeId")
    private Showtime showtime;

    public boolean isTaken() {
        return isTaken;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public Seat(boolean isTaken, double price, int seatNumber, Showtime showtime) {
        this.isTaken = isTaken;
        this.price = price;
        this.seatNumber = seatNumber;
        this.showtime = showtime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seat() {

    }


}
