// package com.example.MovieTheaterTicketApp.model;

// import com.example.MovieTheaterTicketApp.service.EmailService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;

// import java.util.Set;

// public class SendMovieNews {

//     private String news;
//     private boolean status;


//     @Autowired
//     private JavaMailSender mailSender;

//     public SendMovieNews() {
//         this.status = false;
//     }

//     public String getNews() {
//         return news;
//     }

//     public void setNews(String news) {
//         this.news = news;
//     }

//     public void emailAll(Set<String> userEmails){

//         for(String toEmail:userEmails){
//             SimpleMailMessage message = new SimpleMailMessage();
//             message.setFrom("moussavitheaters@gmail.com");
//             message.setTo(toEmail);
//             message.setText(this.news);
//             message.setSubject("Email News from Moussavi theatres!");
//             this.mailSender.send(message);
//         }
//         this.status = true;
//     }

//     public boolean printStatus(){
//         return this.status;
// //         sent or not
//     }

// }
