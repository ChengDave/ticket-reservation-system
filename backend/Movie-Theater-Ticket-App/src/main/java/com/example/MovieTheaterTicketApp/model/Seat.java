package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

@Entity(name = "Seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "isTaken",
            nullable = false,
            columnDefinition = "Boolean"
    )
    private boolean isTaken;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "price"
    )
    private double price;

    @Column(
            name = "seatNumber",
            nullable = false,
            columnDefinition = "seatNumber"
    )
    private Integer seatNumber;

    public boolean isTaken() {
        return isTaken;
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

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public Seat(boolean isTaken, float price, Integer seatNumber) {
        this.isTaken = isTaken;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public Seat() {

    }


}
