package com.example.MovieTheaterTicketApp.controller;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.MovieTheaterTicketApp.model.Payment;
import com.example.MovieTheaterTicketApp.model.Receipt;
import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.service.PaymentService;
import com.example.MovieTheaterTicketApp.service.UserService;

@RequestMapping("api/v1/payment")
@RestController
public class PaymentController {

    PaymentService paymentService;
    UserService userService;

    @Autowired
    public PaymentController(PaymentService paymentService, UserService userService) {
        this.paymentService = paymentService;
        this.userService = userService;
    }
    
    @PostMapping
    public Payment addPayment(@RequestBody Payment payment){

        // TODO: Garnet's Comments. I don't like that this takes the id and userID. I think it should take the user/username and look that up. I currently have 1 hardcoded.
        // TODO: Need a response confirming the payment was good or not. Might need to hard code it but we are supposed to display that to the user

        // Check if the credit card has enough money for the payment to go through 
        
        //generate date and time and add to the created payment object
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        payment.setPaymentDate(dtf.format(now).substring(0,10));
        payment.setPaymentTime(dtf.format(now).substring(11));

        // Assign credit card type based on the first digit of the credit card number.
        RegisteredUser user = userService.getUser(payment.getUserId());

        paymentService.addPayment(payment);
        Long receiptId = paymentService.genReceipt(payment);
        
        // Adding receipt to User
        userService.addReceipt(user, receiptId);
        if (payment.getCreditCardNo() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment did not go through");
        }
        else{
           return payment; 
        }  
    }

    // @PostMapping(value = "/makePayment", consumes = MediaType.APPLICATION_JSON_VALUE)
    // public void getPayment(@RequestBody Payment payment){
    //     paymentService.addPayment(payment);
    // }
    
    // @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    
    // @GetMapping()
    // public List<Payment> getAllPayments(){
    //     List<Payment> test = new ArrayList<>();
    //     test.add(new Payment(1l, 1l, 0, "123", "123", "123", 10.0, 1l));
    //     test.add(new Payment(1l, 1l, 0, "123", "123", "123", 10.0, 1l));
    //     test.add(new Payment(1l, 1l, 0, "123", "123", "123", 10.0, 1l));
    //     return (List<Payment>) test;
    // }

    // @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping(path = "{id}")
    public Payment getPaymentById(@PathVariable("id") Long id){
 
        if (!paymentService.getPaymentById(id).isEmpty()){
            Payment  p = paymentService.getPaymentById(id).get();
            return p;
        }
        else{return null;}
    }

    @GetMapping(path = "receipt/{id}")
    public Receipt getReciept(@PathVariable Long id){
 
        if (!paymentService.getRecieptById(id).isEmpty()){
            Receipt r = paymentService.getRecieptById(id).get();
            return r;
        }
        else{return null;}
    }
    
    // @CrossOrigin(origins = "http://127.0.0.1:5501")
    // @DeleteMapping(path = "{id}")
    // public void deletePaymentById(@PathVariable("id") int id){
    //     PaymentService.deletePayment (id);
    // }

    // @DeleteMapping
    // public void deleteAll(){
    //     PaymentService.deleteAll();
    // }

    // @PutMapping(path = "{id}")
    // public void updatePayment (@PathVariable("id") int id, @Valid @NonNull @RequestBody Payment  Payment ToUpdate){
    //     PaymentService.updatePayment (id, Payment ToUpdate);
    // }
    


    
}
