package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

@Entity(name = "Theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "theaterTitle",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String theaterTitle;

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", theaterTitle='" + theaterTitle + '\'' +
                '}';
    }

    public Theater() {

    }

    public Theater(String theaterTitle) {
        this.theaterTitle = theaterTitle;
    }


    public String getTheaterTitle() {
        return theaterTitle;
    }

    public void setTheaterTitle(String movieTitle) {
        this.theaterTitle = movieTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
