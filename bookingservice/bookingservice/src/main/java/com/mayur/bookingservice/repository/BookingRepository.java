package com.mayur.bookingservice.repository;

import com.mayur.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByReferenceNumber(String referenceNumber);
}

