package com.example.MovieTheaterTicketApp.controller;
import com.example.MovieTheaterTicketApp.model.Movie;
import com.example.MovieTheaterTicketApp.service.EmailService;
import com.example.MovieTheaterTicketApp.service.MovieService;
import com.example.MovieTheaterTicketApp.service.TicketService;
import com.example.MovieTheaterTicketApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private final TicketService ticketService;
    private EmailService emailService;
    private UserService userService;

    @Autowired
    public MovieController(MovieService movieService, TicketService ticketService, 
                            EmailService emailService,
                            UserService userService) {
        this.movieService = movieService;
        this.ticketService = ticketService;
        this.emailService = emailService;
        this.userService = userService;
    }

    @GetMapping()
    public List<Movie> getMovies(){
        // return list of all movies
        return movieService.getMovies();
    }

    @GetMapping(path = "movieTitle/{movieTitle}")
    public Movie getMovies(@PathVariable("movieTitle") String movieTitle){
        return movieService.getMovieByMovieTitle(movieTitle);
    }

    @GetMapping(path = "partialMovieTitle/{pMovieTitle}")
    public List<Movie> getPartialMovieNames(@PathVariable("pMovieTitle") String movieTitle){
        return movieService.getMovieByPartialMovieTitle(movieTitle);
    }

    @PostMapping()
    public void addMovie(@RequestBody Movie movie){
        // add movie to db
        movieService.addMovie(movie);
        emailService.sendMovieNews(userService.getRegUsers(), movie.getMovieTitle());
    }

    @DeleteMapping()
    public void removeMovie(@RequestBody Movie movie){
        // remove movie from db
        movieService.removeMovie(movie);
    }

//    @PostMapping(path = "movieId/{movieId}/TicketId/{ticketId}")
//    public void selectMovieToView(@PathVariable("movieId") Long movieId,
//                                @PathVariable("ticketId") Long ticketId){
//        // choose a movie to view and update that info in the ticket
//        ticketService.updateTicketMovie(ticketId, movieId);
//    }


}
