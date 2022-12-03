package com.example.MovieTheaterTicketApp.model;

import javax.persistence.*;

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
            name = "password",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String password;

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

    @Column(
        name = "refund",
        nullable = true,
        columnDefinition = "BOOLEAN"
    )
    private boolean refund;

    @Column(
        name = "credit",
        nullable = true,
        columnDefinition = "DOUBLE"
    )
    private double credit;


    @Column(
        name = "address",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String address;

    @Column(
        name = "city",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String city;

    @Column(
        name = "province",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String province;

    @Column(
        name = "country",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String country;

    @Column(
        name = "postal",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String postal;

    protected RegisteredUser() {
    }

    public RegisteredUser(String firstName,
                          String lastName,
                          String email,
                          String password,
                          String creditCard,
                          boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email =  email;
        this.password = password;
        this.creditCard = creditCard;
        this.isAdmin = isAdmin;
        this.isRegistered = true;
        this.refund = false;
        this.credit = 0.0;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public double removeFromCredit(double amount) {
        double sub = 0.0;
        if (credit < amount){
           sub = credit - amount;
           credit = 0.0;
           return sub;
        }
        else if (credit >= amount){
            credit = credit - amount;
        }
        return sub;
    }

    public void addToCredit(double amount) {
        credit += amount;
    }

}

