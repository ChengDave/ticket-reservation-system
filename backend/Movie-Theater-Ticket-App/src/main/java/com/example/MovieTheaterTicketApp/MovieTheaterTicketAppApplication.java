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

			user_repository.save(new RegisteredUser("Garnet", "4444444444444444", "Crookes", "garnet.crookes@ucalgary.ca", "pass", false, 4444444444444444l, "Garnet Crookes", "05/25", 123));
			user_repository.save(new RegisteredUser("David", "5555555555555555", " Cheng", "david.cheng1@ucalgary.ca", "pass", false, 5555555555555555l, "David Cheng", "05/25", 123));
			user_repository.save(new RegisteredUser("Sola", "3333333333333333", "Akinbode", "olusola.akinbode@ucalgary.ca", "pass", false, 3333333333333333l, "Sola Akinbode", "05/25", 123));
			user_repository.save(new RegisteredUser("Usman", "4444444488888888", "Zia", "usman.zia@ucalgary.ca", "pass", false, 4444444488888888l, "Usman Zia", "05/25", 123));

			Theater theater1 = new Theater("Calgary Market Mall");
			Theater theater2 = new Theater("Crowfoot Crossing");
			Theater theater3 = new Theater("Chinook");

			List<Movie> movies = new ArrayList<>();

			Movie movie1 = new Movie("Avatar: The Way of Water",LocalDateTime.of(2022, 12, 1, 0, 0));
			movie1.setNews("DIRECTOR\r\nJames Cameron\nCAST\nSam Worthington, Zoe Saldaña, Sigourney Weaver, Kate Winslet, Vin Diesel, Stephen Lang, Giovanni Ribisi, Edie Falco, Michelle Yeoh, Joel David Moore, Cliff Curtis, David Thewlis, Oona Chaplin, CCH Pounder, Matt Gerald, Jemaine Clement, Jamie Flatters, Britain Dalton, Jack Champion, Trinity Bliss, Duane Evans Jr., Filip Geljo, Bailey Bass, Dileep Rao, Chloe Chase Coleman, Keston John\nPRODUCERS\nJon Landau, James Cameron, Peter M. Tobyansen\nWRITERS\nJames Cameron, Josh Friedman, Amanda Silver, Rick Jaffa, Shane Salerno");

			Movie movie2 = new Movie("Black Adam",LocalDateTime.of(2022, 12, 1, 0, 0));
			Movie movie3 = new Movie("Black Panther: Wakanda Forever",LocalDateTime.of(2022, 12, 1, 0, 0));
			Movie movie4 = new Movie("Bones and All",LocalDateTime.of(2023, 3, 1, 0, 0));// pre public announcement

			movie2.setNews("From New Line Cinema, Dwayne Johnson stars in the action adventure “Black Adam.” The first-ever feature film to explore the story of the DC antihero comes to the big screen under the direction of Jaume Collet-Serra (“Jungle Cruise”). In ancient Kahndaq, the slave Teth Adam was gifted the almighty powers of the gods. But he used those powers for vengeance and was imprisoned. Now, 5,000 years later, he is freed and once again wields his dark sense of justice onto the world. Refusing to surrender, Teth Adam is challenged by a team of modern day heroes known as the Justice Society—Hawkman, Doctor Fate, Atom Smasher and Cyclone—who seek to return him to eternal captivity. Johnson stars alongside Aldis Hodge (“City on a Hill,” “One Night in Miami”) as Hawkman, Noah Centineo (“To All the Boys I’ve Loved Before”) as Atom Smasher, Sarah Shahi (“Sex/Life,” “Rush Hour 3”), Marwan Kenzari (“Murder on the Orient Express,” “Aladdin”), Quintessa Swindell (“Voyagers,” “Trinkets”) as Cyclone, Mo Amer (“Mo,” “Ramy”), Bodhi Sabongui (“A Million Little Things”), and Pierce Brosnan (the James Bond and “Mamma Mia!” franchises) as Doctor Fate.\nDIRECTOR\nJames Collet-Sierra\nCAST\nDwayne Johnson");
			movie3.setNews("In Marvel Studios’ “Black Panther: Wakanda Forever,” Queen Ramonda (Angela Bassett), Shuri (Letitia Wright), M’Baku (Winston Duke), Okoye (Danai Gurira) and the Dora Milaje (including Florence Kasumba), fight to protect their nation from intervening world powers in the wake of King T’Challa’s death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia (Lupita Nyong’o) and Everett Ross (Martin Freeman) and forge a new path for the kingdom of Wakanda. Introducing Tenoch Huerta Mejía as Namor, king of a hidden undersea nation, the film also stars Dominique Thorne, Michaela Coel, Mabel Cadena and Alex Livanalli.\nDIRECTOR\nRyan Coogler\nCAST\nLetitia Wright, Martin Freeman, Daniel Kaluyaa");
			movie4.setNews("A story of first love between Maren, a young woman learning how to survive on the margins of society, and Lee, an intense and disenfranchised drifter, as they meet and join together for a thousandmile odyssey which takes them through the back roads, hidden passages, and trap doors of Ronald Reagan’s America. But despite their best efforts, all roads lead back to their terrifying pasts and to a final stand which will determine whether their love can survive their otherness.\nDIRECTOR\nLuca Guadagnino\nCAST\nTimothee Chalamet, Taylor Russell, Mark Rylance, Andre Holland, Jessica Harper, Michael Stuhlbarg, David Gordon Green, Francesca Scorsese, Chloe Sevigny\nPRODUCERS\nLuca Guadagnino, Theresa Park, Marco Morabito, Dave Kajganich, Francesco Melzi D'Eril, Lorenzo Mieli, Gabriele Moratti, Peter Spears, Timothée Chalamet\nWRITERS\nDave Kajganich");

			movies.add(movie1);
			movies.add(movie2);
			movies.add(movie3);
			movies.add(movie4);
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
					for (int day = 7; day < 11; day ++) {
						Showtime showtime1 = (new Showtime(movies.get(i), theater1, LocalDateTime.of(2022, 12, day, hour, 30+i)));
						Showtime showtime2 = (new Showtime(movies.get(i), theater2, LocalDateTime.of(2022, 12, day, hour, 00+i)));
						// Showtime showtime3 = (new Showtime(movies.get(i), theater3, LocalDateTime.of(2022, 12, day, hour, 40+i)));


						showtimes.add(showtime1);
						showtimes.add(showtime2);
						// showtimes.add(showtime3);

						for(int s=1; s<21; s++){
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

		};

	}

}
