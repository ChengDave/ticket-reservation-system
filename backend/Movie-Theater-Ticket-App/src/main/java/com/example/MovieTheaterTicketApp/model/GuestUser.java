package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

@Table
@Entity(name = "GuestUser")
public class GuestUser implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;


    protected GuestUser() {
    }

    public GuestUser(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
