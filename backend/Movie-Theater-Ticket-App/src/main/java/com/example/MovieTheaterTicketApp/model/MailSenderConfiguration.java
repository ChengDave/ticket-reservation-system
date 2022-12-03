package com.example.MovieTheaterTicketApp.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailSenderConfiguration {

   @Bean("javaMailSender")
   public JavaMailSender javaMailSender() {
       JavaMailSenderImpl sender = new JavaMailSenderImpl();
       sender.setHost("smtp.gmail.com");
       sender.setPort(587);
       sender.setUsername("moussavitheaters@gmail.com");
       sender.setPassword("egxrepyexzgysgpg");

       Properties props = sender.getJavaMailProperties();
       props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.debug", "true");

       return sender;
   }

   @Bean
	public SimpleMailMessage emailTemplate()
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("akinbode@gmail.com");
		message.setFrom("moussavitheaters@gmail.com");
	    message.setText("Testing the email!");
	    return message;
	}

   @Bean("RegisteredUser")
    public RegisteredUser registeredUser(){
        return new RegisteredUser();
    }
}