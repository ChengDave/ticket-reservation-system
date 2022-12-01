package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "RegisteredUser")
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

    @Column(
            name = "ticketNo",
            nullable = true,
            columnDefinition = "LONG"
    )
    private Long ticketNo;

    @Column(
            name = "receiptNo",
            nullable = true,
            columnDefinition = "LONG"
    )
    private Long receiptNo;

    @Column(
        name = "creditCardNumber",
        nullable = true,
        columnDefinition = "LONG"
    )
    private Long creditCardNumber;

    @Column(
        name = "nameOnCard",
        nullable = true,
        columnDefinition = "varchar(255)"
    )
    private String nameOnCard;

    @Column(
        name = "cardExpirationDate",
        nullable = true,
        columnDefinition = "varchar(255)"
    )
    private String cardExpirationDate;

    @Column(
        name = "cardCVV",
        nullable = true,
        columnDefinition = "INT"
    )
    private int cardCVV;
    
    @Column(
        name = "isRegistered",
        nullable = true,
        columnDefinition = "BOOLEAN"
    )
    private boolean isRegistered;


    protected RegisteredUser() {
    }

    public RegisteredUser(String firstName,
                          String lastName,
                          String email,
                          String creditCard,
                          boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email =  email;
        this.creditCard = creditCard;
        this.isAdmin = isAdmin;
        this.isRegistered = true;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Long getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(Long receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public int getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(int cardCVV) {
        this.cardCVV = cardCVV;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    @Override
    public String toString() {
        return "RegisteredUser [id=" + id + ", firstName=" + firstName + ", creditCard=" + creditCard + ", lastName="
                + lastName + ", email=" + email + ", isAdmin=" + isAdmin + ", ticketNo=" + ticketNo + ", receiptNo="
                + receiptNo + "]";
    }

    
}

