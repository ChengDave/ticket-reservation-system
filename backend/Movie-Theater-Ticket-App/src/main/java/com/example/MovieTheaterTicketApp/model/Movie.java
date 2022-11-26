package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

@Entity(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "movieTitle",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String movieTitle;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }

    public Movie() {

    }
    public Movie(String movieTitle) {
        this.movieTitle = movieTitle;
    }



    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
