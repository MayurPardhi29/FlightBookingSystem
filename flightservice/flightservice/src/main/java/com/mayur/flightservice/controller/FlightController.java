package com.mayur.flightservice.controller;

import com.mayur.flightservice.model.Flight;
import com.mayur.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam String departure,
            @RequestParam String arrival,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return flightService.searchFlights(departure, arrival, date);
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }
}
