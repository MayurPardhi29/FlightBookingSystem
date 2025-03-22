package com.mayur.bookingservice.controller;


import com.mayur.bookingservice.model.Booking;
import com.mayur.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmBooking(
            @RequestParam Long flightId,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String gender) {
        String referenceNumber = bookingService.confirmBooking(flightId, firstName, lastName, gender);
        return ResponseEntity.ok("Your booking is confirmed. Reference number is " + referenceNumber);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBooking(@RequestParam String referenceNumber) {
        Booking booking = bookingService.findByReferenceNumber(referenceNumber);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        }
    }
}