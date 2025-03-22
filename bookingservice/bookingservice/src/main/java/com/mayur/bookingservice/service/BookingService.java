package com.mayur.bookingservice.service;

import com.mayur.bookingservice.model.Booking;
import com.mayur.bookingservice.repository.BookingRepository;
import com.mayur.flightservice.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BookingService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookingRepository bookingRepository;

    private static final String FLIGHT_SERVICE_URL = "http://localhost:8081/flights";

    public Flight getFlightById(Long flightId) {
        String url = FLIGHT_SERVICE_URL + "/" + flightId;
        return restTemplate.getForObject(url, Flight.class);
    }

    public String confirmBooking(Long flightId, String firstName, String lastName, String gender) {
        try {
            // Fetch flight details from FlightService
            Flight flight = restTemplate.getForObject(FLIGHT_SERVICE_URL + "/" + flightId, Flight.class);

            // Create booking
            Booking booking = new Booking();
            booking.setPassengerFirstName(firstName);
            booking.setPassengerLastName(lastName);
            booking.setGender(gender);
            booking.setFlightNumber(flight.getFlightNumber());
            booking.setBookingTime(LocalDateTime.now());
            booking.setStatus("CONFIRMED");
            booking.setReferenceNumber(UUID.randomUUID().toString());

            // Save booking
            bookingRepository.save(booking);

            return booking.getReferenceNumber();
        } catch (HttpClientErrorException.NotFound ex) {
            throw new RuntimeException("Flight not found with id: " + flightId);
        }
    }

    public Booking findByReferenceNumber(String referenceNumber) {
        return bookingRepository.findByReferenceNumber(referenceNumber);
    }
}
