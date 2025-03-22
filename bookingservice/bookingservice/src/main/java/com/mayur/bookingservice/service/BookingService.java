package com.mayur.bookingservice.service;

import com.mayur.bookingservice.model.Booking;
import com.mayur.bookingservice.repository.BookingRepository;
import com.mayur.flightservice.exception.ResourceNotFoundException;
import com.mayur.flightservice.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String FLIGHT_SERVICE_URL = "http://localhost:8081/flights";

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    public String confirmBooking(Long flightId, String firstName, String lastName, String gender) {
        Flight flight = restTemplate.getForObject(FLIGHT_SERVICE_URL + "/" + flightId, Flight.class);
        Booking booking = new Booking();
        booking.setPassengerFirstName(firstName);
        booking.setPassengerLastName(lastName);
        booking.setGender(gender);
        booking.setFlightNumber(flight.getFlightNumber());
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("CONFIRMED");
        booking.setReferenceNumber(UUID.randomUUID().toString());
        return bookingRepository.save(booking).getReferenceNumber();
    }

    public Booking findByReferenceNumber(String referenceNumber) {
        return bookingRepository.findByReferenceNumber(referenceNumber);
    }

    public Booking updateBooking(Long id, Booking booking) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setPassengerFirstName(booking.getPassengerFirstName());
        existingBooking.setPassengerLastName(booking.getPassengerLastName());
        existingBooking.setGender(booking.getGender());
        existingBooking.setFlightNumber(booking.getFlightNumber());
        existingBooking.setStatus(booking.getStatus());
        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}