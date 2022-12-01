package com.example.MovieTheaterTicketApp.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;



public class EmailTicketAndReceipt {
    @Autowired
    private JavaMailSender mailSender;
    private String status = "Not Sent";

    private  User user;
//    private final Receipt receipt;


    public EmailTicketAndReceipt( User user) {
        this.user = user;
    }

    public void emailUser(User user,String toEmail){
        this.user =user;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("moussavitheaters@gmail.com");
        message.setTo(toEmail);
        //message.setText(body);
        message.setSubject("Receipt and Ticket for your recent purchase");
//
//        Still need to attach receipt and ticket in email
//
//        How do i access the receipt and ticket?
        mailSender.send(message);
        this.status = "Sent";

    }

    public String printStatus(){
        return this.status;
        // sent or not
    }

}
