package com.mayur.bookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerFirstName;
    private String passengerLastName;
    private String gender;
    private String flightNumber;
    private String referenceNumber;
    private LocalDateTime bookingTime;
    private String status;

    // ✅ No-Args Constructor
    public Booking() {}

    // ✅ All-Args Constructor
    public Booking(Long id, String passengerFirstName, String passengerLastName,
                   String gender, String flightNumber, String referenceNumber,
                   LocalDateTime bookingTime, String status) {
        this.id = id;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.gender = gender;
        this.flightNumber = flightNumber;
        this.referenceNumber = referenceNumber;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPassengerFirstName() { return passengerFirstName; }
    public void setPassengerFirstName(String passengerFirstName) { this.passengerFirstName = passengerFirstName; }

    public String getPassengerLastName() { return passengerLastName; }
    public void setPassengerLastName(String passengerLastName) { this.passengerLastName = passengerLastName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }

    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ✅ Override toString
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", gender='" + gender + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", bookingTime=" + bookingTime +
                ", status='" + status + '\'' +
                '}';
    }

    // ✅ Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(referenceNumber, booking.referenceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceNumber);
    }
}
