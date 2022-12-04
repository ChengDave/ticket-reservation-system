package com.example.MovieTheaterTicketApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double amount;
    String date;
    String user;
    Long receiptNo;

    public Receipt(){
    }

    public Receipt(Long id, Double amount, String date, String user, Long receiptNo) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.user = user;
        this.receiptNo = receiptNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(Long receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String emailText(){
        String text = "ReceiptNo: " + receiptNo + "\n" + 
                    "Amount: : " + amount + "\n" +
                    "Name: " + user + "\n" +
                    "Date: " + date;
        return text;
    }

    
    
}
