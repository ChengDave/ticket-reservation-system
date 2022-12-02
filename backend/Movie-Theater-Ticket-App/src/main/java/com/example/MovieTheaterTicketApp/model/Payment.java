package com.example.MovieTheaterTicketApp.model;

import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long creditCardNo;
    int cvv;
    String creditCardExpDate;
    String paymentDate;
    String paymentTime;
    Double paymentAmount;
    Long UserId;
    
    private transient CreditCard creditCard;

    public Payment(){
        super();
    }

    public Payment(Long id, 
            @JsonProperty("creditCardNo")Long creditCardNo, 
            @JsonProperty("cvv")int cvv, 
            @JsonProperty("creditCardExpDate")String creditCardExpDate, 
            String paymentDate,
            String paymentTime, 
            @JsonProperty("paymentAmount")Double paymentAmount, 
            @JsonProperty("userId")Long userId) {
        this.id = id;
        this.creditCardNo = creditCardNo;
        this.cvv = cvv;
        this.creditCardExpDate = creditCardExpDate;
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.paymentAmount = paymentAmount;
        this.UserId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(Long creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCreditCardExpDate() {
        return creditCardExpDate;
    }

    public void setCreditCardExpDate(String creditCardExpDate) {
        this.creditCardExpDate = creditCardExpDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public void setCreditCardStrategy(CreditCard creditCard){
        this.creditCard = creditCard;
    }

    public void debitCreditCard(){
        creditCard.debitCard(paymentAmount);
    }

    @Override
    public String toString() {
        return "Payment{id=" + id + ", creditCardNo=" + creditCardNo + ", cvv=" + cvv + ", creditCardExpDate="
                + creditCardExpDate + ", paymentDate=" + paymentDate + ", paymentTime=" + paymentTime
                + ", paymentAmount=" + paymentAmount + ", UserId=" + UserId + "}";
    }

    


    
    
}
