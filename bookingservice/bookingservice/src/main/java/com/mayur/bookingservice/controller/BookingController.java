package com.mayur.bookingservice.controller;

import com.mayur.bookingservice.model.Booking;
import com.mayur.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Get a booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    // Confirm a booking
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmBooking(
            @RequestParam Long flightId,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String gender) {
        String referenceNumber = bookingService.confirmBooking(flightId, firstName, lastName, gender);
        return ResponseEntity.ok("Your booking is confirmed. Reference number is " + referenceNumber);
    }

    // Search for a booking by reference number
    @GetMapping("/search")
    public ResponseEntity<?> searchBooking(@RequestParam String referenceNumber) {
        Booking booking = bookingService.findByReferenceNumber(referenceNumber);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        }
    }

    // Update a booking by ID
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBooking(id, booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    // Delete a booking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}