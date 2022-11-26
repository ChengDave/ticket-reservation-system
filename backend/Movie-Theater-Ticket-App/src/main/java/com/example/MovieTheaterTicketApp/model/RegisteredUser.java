package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

@Entity(name = "RegisteredUser")
@Table(name="registeredUser",
        uniqueConstraints = {
        @UniqueConstraint(name="email_unque",columnNames = "email")
        }
)
public class RegisteredUser implements User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "firstName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "creditCard",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String creditCard;


    @Column(
            name = "lastName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "isAdmin",
            nullable = false,
            columnDefinition = "BOOLEAN"
    )
    private boolean isAdmin;


    protected RegisteredUser() {
    }

    public RegisteredUser(String firstName,
                          String lastName,
                          String email,
                          String creditCard,
                          boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.creditCard = creditCard;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}

