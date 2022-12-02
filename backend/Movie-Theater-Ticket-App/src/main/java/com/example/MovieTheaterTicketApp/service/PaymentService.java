package com.example.MovieTheaterTicketApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieTheaterTicketApp.model.AmexCreditCard;
import com.example.MovieTheaterTicketApp.model.MasterCardCreditCard;
import com.example.MovieTheaterTicketApp.model.Payment;
import com.example.MovieTheaterTicketApp.model.Receipt;
import com.example.MovieTheaterTicketApp.model.VisaCreditCard;
import com.example.MovieTheaterTicketApp.repository.PaymentRepository;
import com.example.MovieTheaterTicketApp.repository.ReceiptRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepo;
    private final ReceiptRepository receiptRepo;

    @Autowired
    public PaymentService(PaymentRepository paymentRepo, ReceiptRepository receiptRepo) {
        this.paymentRepo = paymentRepo;
        this.receiptRepo = receiptRepo;
    }


    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public void addPayment(Payment payment, Long creditCardNo) {
        String ccn = String.valueOf(creditCardNo);

        if (ccn.startsWith("3")){
            payment.setCreditCardStrategy(new AmexCreditCard());
        }

        else if (ccn.startsWith("4")){
            payment.setCreditCardStrategy(new VisaCreditCard());
        }

        else if (ccn.startsWith("5")){
            payment.setCreditCardStrategy(new MasterCardCreditCard());
        }
    
        payment.debitCreditCard();
        paymentRepo.save(payment);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepo.findById(id);
    }

    public void deletePayment(Long id){
        paymentRepo.deleteById(id);
    }

    public Long genReceipt(Payment payment){
        Receipt receipt = new Receipt((long) 1234, payment.getPaymentAmount(), 
            payment.getPaymentDate(), "user", payment.getId());

        receiptRepo.save(receipt);
        return receipt.getId();
    }

    public Optional<Receipt> getRecieptById(Long id){
        return receiptRepo.findById(id);
    }

    // public void updatePayment(Long id, Payment Payment){
    //    paymentRepo.deleteById(id);
    //    paymentRepo.save(new Payment(id, Payment.getName()));
    // }

    public void deleteAll(){
        paymentRepo.deleteAll();
    }
    

    // A way to verify that the credit card has enough balance to affect the transaction
    // A way to check that the credit card is valid, is not expired
    // reduce the balance in credit card
}

