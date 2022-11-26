package com.example.MovieTheaterTicketApp;

import com.example.MovieTheaterTicketApp.model.RegisteredUser;
import com.example.MovieTheaterTicketApp.model.User;
import com.example.MovieTheaterTicketApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MovieTheaterTicketAppApplication {

	private static final Logger log = LoggerFactory.getLogger(MovieTheaterTicketAppApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MovieTheaterTicketAppApplication.class);

	}

	@Bean
	public CommandLineRunner DataLoader(UserRepository user_repository) {
		return (args) -> {
			// save a few customers
			user_repository.save(new RegisteredUser("Jack", "Bauer", "test1@gmail.com","123" ,false));
			user_repository.save(new RegisteredUser("Chloe", "O'Brian","test2@gmail.com","123",false));
			user_repository.save(new RegisteredUser("Kim", "Bauer","test3@gmail.com","123",true));

			// fetch all customers
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User customer : user_repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
//
//			// fetch an individual customer by ID
//			User customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			//  log.info(bauer.toString());
//			// }
//			log.info("");
		};
	}

}
