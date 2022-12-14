package com.example.MovieTheaterTicketApp.service;
// import com.example.MovieTheaterTicketApp.model.EmailTicketAndReceipt;
import com.example.MovieTheaterTicketApp.model.Receipt;
import com.example.MovieTheaterTicketApp.model.RegisteredUser;

import com.example.MovieTheaterTicketApp.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmailService {
    private UserService userService;
    private RegisteredUser user1;
    private PaymentService payService;
    private TicketService ticketService;
    private Ticket ticket;
    private Receipt receipt;
    private String status = "Not Sent";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage preConfiguredMessage;

    
    @Autowired
    public EmailService(JavaMailSender mailSender, UserService userService, RegisteredUser user1, PaymentService payService,
            TicketService ticketService) {
        this.userService = userService;
        this.user1 = user1;
        this.payService = payService;
        this.ticketService = ticketService;
    }

    public void emailReceiptAndTicket(RegisteredUser user){

        Long ticketID = user.getTicketNo();
        Long receiptID = user.getReceiptNo();

        ticket  = ticketService.getTicketById(ticketID).get();
        receipt = payService.getRecieptById(receiptID).get();

        String receiptText = receipt.toString();
        String ticketText = ticket.toString();

        String body = receiptText + ticketText;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("moussavitheaters@gmail.com");
        message.setTo(user.getEmail());
        message.setText(body);
        message.setSubject("Receipt and Ticket for your recent purchase");

        mailSender.send(message);
        this.status = "Sent";

    }

    public void emailTicket(RegisteredUser user, String Ticket){

        String body = "-------Here is your ticket------\n" + Ticket;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("moussavitheaters@gmail.com");
        message.setTo(user.getEmail());
        message.setText(body);
        message.setSubject("Ticket for your recent purchase");

        mailSender.send(message);
        this.status = "Sent";

    }


    public void emailReceipt(RegisteredUser user, String Receipt){

        String body = "-------Here is your receipt------\n" + Receipt;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("moussavitheaters@gmail.com");
        message.setTo(user.getEmail());
        message.setText(body);
        message.setSubject("Receipt for your recent purchase");

        mailSender.send(message);
        this.status = "Sent";

    }

    public void sendMovieNews(List<RegisteredUser> user, String movieTitle){
        RegisteredUser regUser;
        SimpleMailMessage message;

        String intro = "Hello there! \nA new exciting movie has just been released! \n";
        String format = "Title: " + movieTitle + "\n" + "Release date: Today!\n Get your tickets early by visiting www.moviesRus.ca" ;


        for (int i = 0; i < user.size(); i++){
            regUser = user.get(i);
            String email = regUser.getEmail();

            message = new SimpleMailMessage();

            message.setFrom("moussavitheaters@gmail.com");
            message.setTo(email);
            message.setText(intro + format);
            message.setSubject("Latest movie news");
    
            mailSender.send(message);
            this.status = "Sent";
        }


    }
}
