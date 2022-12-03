package com.example.MovieTheaterTicketApp;

import com.example.MovieTheaterTicketApp.model.*;
import com.example.MovieTheaterTicketApp.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MovieTheaterTicketAppApplication {

	private static final Logger log = LoggerFactory.getLogger(MovieTheaterTicketAppApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MovieTheaterTicketAppApplication.class);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}

	@Bean
	public CommandLineRunner DataLoader(UserRepository user_repository,
										TheaterRepository theater_repository,
										MovieRepository movie_repository,
										ShowtimeRepository showtime_repository,
										SeatRepository seat_repository,
										TicketRepository ticket_repository){
		return (args) -> {
			// save a few customers
			user_repository.save(new RegisteredUser("Jack", "Bauer", "akinbodesola@yahoo.co.uk", "pass1", "3333" ,false));
			user_repository.save(new RegisteredUser("Chloe", "O'Brian","akinbodesola@yahoo.co.uk", "pass2", "423",false));
			user_repository.save(new RegisteredUser("Kim", "Bauer","akinbodesola@yahoo.co.uk", "pass3", "523",true));
			user_repository.save(new RegisteredUser("Garnet", "Crookes","akinbodesola@yahoo.co.uk", "1", "423",true));

			Theater theater1 = new Theater("Calgary Market Mall");
			Theater theater2 = new Theater("Crowfoot Crossing");
			Theater theater3 = new Theater("Chinook");

			List<Movie> movies = new ArrayList<>();
			movies.add(new Movie("Avatar: The Way of Water"));
			movies.add(new Movie("Black Adam"));
			movies.add(new Movie("Black Panther: Wakanda Forever"));
			movies.add(new Movie("Bones and All"));
			// movies.add(new Movie("Devotion"));
			// movies.add(new Movie("Glass Onion: A Knives Out Mystery"));
			// movies.add(new Movie("Guillermo Del Toro's Pinocchio"));
			// movies.add(new Movie("I Wanna Dance With Somebody"));
			// movies.add(new Movie("Puss In Boots: The Last Wish"));
			// movies.add(new Movie("She Said"));
			// movies.add(new Movie("Strange World"));
			// movies.add(new Movie("The Banshee Of Inisherin"));
			// movies.add(new Movie("The Fabelmans"));
			// movies.add(new Movie("The Menu"));
			// movies.add(new Movie("Ticket to Paradise"));
			// movies.add(new Movie("Violent Night"));

			theater_repository.save(theater1);
			theater_repository.save(theater2);
			// theater_repository.save(theater3);
			movie_repository.saveAll(movies);
			

			for (int i = 0; i < movies.size(); i++) {
				List<Showtime> showtimes = new ArrayList<>();
				List<Seat> seats = new ArrayList<>();

				for (int hour = 15; hour < 23; hour++) {
					for (int day = 7; day < 9; day ++) {
						Showtime showtime1 = (new Showtime(movies.get(i), theater1, LocalDateTime.of(2022, 12, day, hour, 30+i)));
						Showtime showtime2 = (new Showtime(movies.get(i), theater2, LocalDateTime.of(2022, 12, day, hour, 00+i)));
						// Showtime showtime3 = (new Showtime(movies.get(i), theater3, LocalDateTime.of(2022, 12, day, hour, 40+i)));


						showtimes.add(showtime1);
						showtimes.add(showtime2);
						// showtimes.add(showtime3);

						for(int s=1; s<10; s++){
							seats.add(new Seat(false, (double) 12.5, s, showtime1));
							seats.add(new Seat(false, (double) 12.5, s, showtime2));
							// seats.add(new Seat(false, (double) 12.5, s, showtime3));
						}
					}
				}
				seat_repository.saveAll(seats);
				showtime_repository.saveAll(showtimes);
			}

			List<Seat> seatsForShow25 = seat_repository.findByshowtime_id((long)1214);
			RegisteredUser testUser = user_repository.findById((long)2);

			for(int i=0;i<(seatsForShow25.size()-5);i++){
				ticket_repository.save(new Ticket(testUser,seatsForShow25.get(i)));
				Seat testSeat = seatsForShow25.get(i);
				testSeat.setTaken(true);
				seat_repository.save(testSeat);
			}

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
