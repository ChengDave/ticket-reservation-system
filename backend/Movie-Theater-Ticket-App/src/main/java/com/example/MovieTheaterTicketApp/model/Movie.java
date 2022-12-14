package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime publicAnnouncement;

    @Column(name = "news", columnDefinition = "TEXT")
    private String news;

    public Movie() {
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public LocalDateTime getPublicAnnouncement() {
        return publicAnnouncement;
    }

    public void setPublicAnnouncement(LocalDateTime releaseDate) {
        this.publicAnnouncement = releaseDate;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Movie(String movieTitle, LocalDateTime releaseDate) {
        this.movieTitle = movieTitle;
        this.publicAnnouncement = releaseDate;
    }
}
