package com.example.MovieTheaterTicketApp.controller;
import com.example.MovieTheaterTicketApp.model.Theater;
import com.example.MovieTheaterTicketApp.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/theaters")
public class TheaterController {
    private final TheaterService TheaterService;

    @Autowired
    public TheaterController(TheaterService TheaterService) {
        this.TheaterService = TheaterService;
    }

    @GetMapping()
    public List<Theater> getTheaters(){
        // return list of all Theaters
        return TheaterService.getTheaters();
    }

    @PostMapping()
    public void addTheater(@RequestBody Theater theater){
        // add Theater to db
        TheaterService.addTheater(theater);
    }

    @DeleteMapping()
    public void removeTheater(@RequestBody Theater theater){
        // remove Theater from db
        TheaterService.removeTheater(theater);
    }
}
