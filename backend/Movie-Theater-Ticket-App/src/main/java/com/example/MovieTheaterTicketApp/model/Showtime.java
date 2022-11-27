package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Movie movieID;

    @ManyToOne
    private Theater theaterID;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    public Showtime(Movie movieID, Theater theaterID, LocalDateTime localDateTime) {
        this.movieID = movieID;
        this.theaterID = theaterID;
        this.localDateTime = localDateTime;
    }

    public Movie getMovieID() {
        return movieID;
    }

    public void setMovieID(Movie movieID) {
        this.movieID = movieID;
    }

    public Theater getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Theater theaterID) {
        this.theaterID = theaterID;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Showtime() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

}
