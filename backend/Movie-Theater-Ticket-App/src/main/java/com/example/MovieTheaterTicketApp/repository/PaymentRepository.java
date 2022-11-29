package com.example.MovieTheaterTicketApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieTheaterTicketApp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
