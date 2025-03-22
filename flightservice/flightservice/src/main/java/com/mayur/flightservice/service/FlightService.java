package com.mayur.flightservice.service;

import com.mayur.flightservice.exception.ResourceNotFoundException;
import com.mayur.flightservice.model.Flight;
import com.mayur.flightservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(String departure, String arrival, LocalDate date) {
        departure = departure.trim();
        arrival = arrival.trim();

        return flightRepository.findByDepartureAndArrivalAndDepartureTimeBetween(
                departure,
                arrival,
                date.atStartOfDay(),
                date.atTime(23, 59, 59)
        );
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
    }

}