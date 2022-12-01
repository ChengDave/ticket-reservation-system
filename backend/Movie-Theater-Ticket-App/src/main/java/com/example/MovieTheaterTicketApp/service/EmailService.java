// package com.example.MovieTheaterTicketApp.service;
// import com.example.MovieTheaterTicketApp.model.EmailTicketAndReceipt;
// import com.example.MovieTheaterTicketApp.model.SendMovieNews;
// import com.example.MovieTheaterTicketApp.model.User;
// //import com.example.MovieTheaterTicketApp.repository.EmailRepository;
// import org.springframework.stereotype.Service;

// import java.util.Set;

// @Service
// public class EmailService {
//     private final User user;



//     private final String email;
//     private final SendMovieNews broadcast;
//     private final EmailTicketAndReceipt emailTicketAndReceipt;




//     public EmailService(User user, String email, SendMovieNews broadcast, EmailTicketAndReceipt emailTicketAndReceipt) {
//         this.user = user;
//         this.email = email;
//         this.broadcast = broadcast;
//         this.emailTicketAndReceipt = emailTicketAndReceipt;
//     }

//     public void emailReceiptAndTicket(User user,String email){
//         //check if receipt and ticket is not null
//         emailTicketAndReceipt.emailUser(user, email);
//     }

//     public boolean emailAllRegUsers(String news){
//         // Need to extract all reg user
//         Set<String> userEmails = extractRegisteredEmails();

//         broadcast.emailAll(userEmails);
//         return false;
//     }

//     public Set<String> extractRegisteredEmails(){
//         return ??;
//     }
// }
