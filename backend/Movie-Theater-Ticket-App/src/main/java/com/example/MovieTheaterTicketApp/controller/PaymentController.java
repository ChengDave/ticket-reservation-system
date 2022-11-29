package com.example.MovieTheaterTicketApp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addPayment(@RequestBody Payment payment){
        // Check if the credit card has enough money for the payment to go through 
        
        //generate date and time and add to the created payment object
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        payment.setPaymentDate(dtf.format(now).substring(0,10));
        payment.setPaymentTime(dtf.format(now).substring(11));
        paymentService.addPayment(payment);
        Long receiptId = paymentService.genReceipt(payment);
        
        //Adding receipt to User
        RegisteredUser user = userService.getUser(payment.getUserId());
        userService.addReceipt(user, receiptId);
    }
    
    // @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

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
