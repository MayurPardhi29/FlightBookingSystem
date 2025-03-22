
# Flight Booking System - API Documentation

This document provides details about the **Flight Booking System**, including API endpoints, request/response formats, and how to use them. The system consists of two services:

- **FlightService**: Manages flight-related operations.
- **BookingService**: Manages booking-related operations.

---

## 📌 FlightService

**Base URL**: `http://localhost:8082/flights`

### 1️⃣ Create a Flight
- **Method**: `POST`
- **Endpoint**: `/`
- **Request Body**:
```json
{
  "flightNumber": "FL123",
  "departure": "New York",
  "arrival": "London",
  "departureTime": "2023-12-25T10:00:00",
  "arrivalTime": "2023-12-25T18:00:00",
  "fare": 500.0
}
```
- **Response**:
```json
{
  "id": 1,
  "flightNumber": "FL123",
  "departure": "New York",
  "arrival": "London",
  "departureTime": "2023-12-25T10:00:00",
  "arrivalTime": "2023-12-25T18:00:00",
  "fare": 500.0
}
```

### 2️⃣ Get All Flights
- **Method**: `GET`
- **Endpoint**: `/`
- **Response**:
```json
[
  {
    "id": 1,
    "flightNumber": "FL123",
    "departure": "New York",
    "arrival": "London",
    "departureTime": "2023-12-25T10:00:00",
    "arrivalTime": "2023-12-25T18:00:00",
    "fare": 500.0
  }
]
```

### 3️⃣ Get a Flight by ID
- **Method**: `GET`
- **Endpoint**: `/{id}`
- **Response**:
```json
{
  "id": 1,
  "flightNumber": "FL123",
  "departure": "New York",
  "arrival": "London",
  "departureTime": "2023-12-25T10:00:00",
  "arrivalTime": "2023-12-25T18:00:00",
  "fare": 500.0
}
```

### 4️⃣ Search Flights
- **Method**: `GET`
- **Endpoint**: `/search?departure=New%20York&arrival=London&date=2023-12-25`
- **Response**:
```json
[
  {
    "id": 1,
    "flightNumber": "FL123",
    "departure": "New York",
    "arrival": "London",
    "departureTime": "2023-12-25T10:00:00",
    "arrivalTime": "2023-12-25T18:00:00",
    "fare": 500.0
  }
]
```

### 5️⃣ Update a Flight
- **Method**: `PUT`
- **Endpoint**: `/{id}`
- **Request Body**:
```json
{
  "flightNumber": "FL123",
  "departure": "New York",
  "arrival": "London",
  "departureTime": "2023-12-25T10:00:00",
  "arrivalTime": "2023-12-25T18:00:00",
  "fare": 550.0
}
```
- **Response**:
```json
{
  "id": 1,
  "flightNumber": "FL123",
  "departure": "New York",
  "arrival": "London",
  "departureTime": "2023-12-25T10:00:00",
  "arrivalTime": "2023-12-25T18:00:00",
  "fare": 550.0
}
```

### 6️⃣ Delete a Flight
- **Method**: `DELETE`
- **Endpoint**: `/{id}`
- **Response**: `204 No Content`

---

## 📌 BookingService

**Base URL**: `http://localhost:8081/bookings`

### 1️⃣ Create a Booking
- **Method**: `POST`
- **Endpoint**: `/`
- **Request Body**:
```json
{
  "passengerFirstName": "John",
  "passengerLastName": "Doe",
  "gender": "Male",
  "flightNumber": "FL123",
  "status": "CONFIRMED"
}
```
- **Response**:
```json
{
  "id": 1,
  "passengerFirstName": "John",
  "passengerLastName": "Doe",
  "gender": "Male",
  "flightNumber": "FL123",
  "bookingTime": "2023-12-25T09:00:00",
  "status": "CONFIRMED",
  "referenceNumber": "abc123-xyz456"
}
```

### 2️⃣ Get All Bookings
- **Method**: `GET`
- **Endpoint**: `/`
- **Response**:
```json
[
  {
    "id": 1,
    "passengerFirstName": "John",
    "passengerLastName": "Doe",
    "gender": "Male",
    "flightNumber": "FL123",
    "bookingTime": "2023-12-25T09:00:00",
    "status": "CONFIRMED",
    "referenceNumber": "abc123-xyz456"
  }
]
```

### 3️⃣ Get a Booking by ID
- **Method**: `GET`
- **Endpoint**: `/{id}`
- **Response**:
```json
{
  "id": 1,
  "passengerFirstName": "John",
  "passengerLastName": "Doe",
  "gender": "Male",
  "flightNumber": "FL123",
  "bookingTime": "2023-12-25T09:00:00",
  "status": "CONFIRMED",
  "referenceNumber": "abc123-xyz456"
}
```

### 4️⃣ Confirm a Booking
- **Method**: `POST`
- **Endpoint**: `/confirm?flightId=1&firstName=John&lastName=Doe&gender=Male`
- **Response**:
```
Your booking is confirmed. Reference number is abc123-xyz456
```

### 5️⃣ Search Booking by Reference Number
- **Method**: `GET`
- **Endpoint**: `/search?referenceNumber=abc123-xyz456`
- **Response**:
```json
{
  "id": 1,
  "passengerFirstName": "John",
  "passengerLastName": "Doe",
  "gender": "Male",
  "flightNumber": "FL123",
  "bookingTime": "2023-12-25T09:00:00",
  "status": "CONFIRMED",
  "referenceNumber": "abc123-xyz456"
}
```

### 6️⃣ Update a Booking
- **Method**: `PUT`
- **Endpoint**: `/{id}`
- **Request Body**:
```json
{
  "passengerFirstName": "Jane",
  "passengerLastName": "Doe",
  "gender": "Female",
  "flightNumber": "FL123",
  "status": "CANCELLED"
}
```
- **Response**:
```json
{
  "id": 1,
  "passengerFirstName": "Jane",
  "passengerLastName": "Doe",
  "gender": "Female",
  "flightNumber": "FL123",
  "bookingTime": "2023-12-25T09:00:00",
  "status": "CANCELLED",
  "referenceNumber": "abc123-xyz456"
}
```

### 7️⃣ Delete a Booking
- **Method**: `DELETE`
- **Endpoint**: `/{id}`
- **Response**: `204 No Content`

