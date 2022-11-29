package com.example.MovieTheaterTicketApp.model;

import org.springframework.stereotype.Component;

@Component
public class CreditCard {

    String issuer;
    String expDate;
    String name;
    int cvv;
    int balance;

    public CreditCard(){

    }

    public CreditCard(String issuer, String expDate, String name, int cvv, int balance) {
        this.issuer = issuer;
        this.expDate = expDate;
        this.name = name;
        this.cvv = cvv;
        this.balance = balance;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    

}

