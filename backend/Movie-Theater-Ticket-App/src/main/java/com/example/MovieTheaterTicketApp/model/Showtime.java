package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="movieId")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="theaterId")
    private Theater theater;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    public Showtime(Movie movie, Theater theater, LocalDateTime localDateTime) {
        this.movie = movie;
        this.theater = theater;
        this.localDateTime = localDateTime;
    }

    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovieID(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Showtime() {

    }

}
