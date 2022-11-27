package com.example.MovieTheaterTicketApp;

import com.example.MovieTheaterTicketApp.model.*;
import com.example.MovieTheaterTicketApp.repository.MovieRepository;
import com.example.MovieTheaterTicketApp.repository.ShowtimeRepository;
import com.example.MovieTheaterTicketApp.repository.TheaterRepository;
import com.example.MovieTheaterTicketApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


@SpringBootApplication
public class MovieTheaterTicketAppApplication {

	private static final Logger log = LoggerFactory.getLogger(MovieTheaterTicketAppApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MovieTheaterTicketAppApplication.class);

	}

	@Bean
	public CommandLineRunner DataLoader(UserRepository user_repository,
										TheaterRepository theater_repository,
										MovieRepository movie_repository,
										ShowtimeRepository showtime_repository) {
		return (args) -> {
			// save a few customers
			user_repository.save(new RegisteredUser("Jack", "Bauer", "test1@gmail.com","123" ,false));
			user_repository.save(new RegisteredUser("Chloe", "O'Brian","test2@gmail.com","123",false));
			user_repository.save(new RegisteredUser("Kim", "Bauer","test3@gmail.com","123",true));

			Theater theater1 = new Theater("Theater1");
			Theater theater2 = new Theater("Theater2");
			Theater theater3 = new Theater("Theater3");

			Movie movie1 = new Movie("Movie1");
			Movie movie2 = new Movie("Movie3");
			Movie movie3 = new Movie("Movie2");

			theater_repository.save(theater1);
			theater_repository.save(theater2);
			theater_repository.save(theater3);

			movie_repository.save(movie1);
			movie_repository.save(movie2);
			movie_repository.save(movie3);

			LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);

			Showtime showtime1 = new Showtime(movie1, theater1, datetime1);
			showtime_repository.save(showtime1);

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
