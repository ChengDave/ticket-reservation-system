package com.example.MovieTheaterTicketApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MovieTheaterTicketApp.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    
}
