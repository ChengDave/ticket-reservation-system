package com.example.MovieTheaterTicketApp.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class MasterCardCreditCard implements CreditCard{

    String issuer;
    String expDate;
    String name;
    int cvv;
    double balance;

    public MasterCardCreditCard(){

    }

    public MasterCardCreditCard(String issuer, String expDate, String name, int cvv) {
        this.issuer = issuer;
        this.expDate = expDate;
        this.name = name;
        this.cvv = cvv;
        this.balance = 200.00;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void debitCard(double amount) {
        balance = balance - amount;
        
    }
    

}

