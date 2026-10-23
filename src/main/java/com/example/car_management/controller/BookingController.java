package com.example.car_management.controller;

import com.example.car_management.entity.Booking;
import com.example.car_management.repository.BookingRepository;
import com.example.car_management.response.BookingResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private static final Logger logger =
            LoggerFactory.getLogger(BookingController.class);

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // 1. CREATE (POST)
    @PostMapping
    public ResponseEntity<BookingResponse> addBooking(
            @RequestBody Booking booking) {

        logger.info("Received request to add a new booking");

        Booking savedBooking = bookingRepository.save(booking);

        logger.info(
                "Booking added successfully with ID: {}",
                savedBooking.getBookingId()
        );

        BookingResponse response =
                new BookingResponse(
                        "Booking added successfully",
                        savedBooking
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    // 2. READ ALL (GET)
    @GetMapping
    public ResponseEntity<BookingResponse> getAllBookings() {

        logger.info("Received request to fetch all bookings");

        List<Booking> bookings = bookingRepository.findAll();

        BookingResponse response =
                new BookingResponse(
                        "Bookings fetched successfully",
                        bookings
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    // 3. READ ONE BY ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(
            @PathVariable Long id) {

        logger.info(
                "Received request to fetch booking with ID: {}",
                id
        );

        Optional<Booking> booking =
                bookingRepository.findById(id);

        if (booking.isPresent()) {

            BookingResponse response =
                    new BookingResponse(
                            "Booking found successfully",
                            booking.get()
                    );

            return new ResponseEntity<>(
                    response,
                    HttpStatus.OK
            );
        }

        BookingResponse response =
                new BookingResponse(
                        "Booking not found",
                        null
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    // 4. UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<BookingResponse> updateBooking(
            @PathVariable Long id,
            @RequestBody Booking updatedBooking) {

        logger.info(
                "Received request to update booking with ID: {}",
                id
        );

        Optional<Booking> existingBookingOptional =
                bookingRepository.findById(id);

        if (existingBookingOptional.isPresent()) {

            Booking existingBooking =
                    existingBookingOptional.get();

            existingBooking.setBookingDate(
                    updatedBooking.getBookingDate()
            );

            existingBooking.setBookingTime(
                    updatedBooking.getBookingTime()
            );

            existingBooking.setBookingStatus(
                    updatedBooking.getBookingStatus()
            );

            existingBooking.setPaymentMethod(
                    updatedBooking.getPaymentMethod()
            );

            existingBooking.setTotalAmount(
                    updatedBooking.getTotalAmount()
            );

            existingBooking.setRemarks(
                    updatedBooking.getRemarks()
            );

            existingBooking.setCustomerId(
                    updatedBooking.getCustomerId()
            );

            existingBooking.setVehicleId(
                    updatedBooking.getVehicleId()
            );

            existingBooking.setServiceId(
                    updatedBooking.getServiceId()
            );

            existingBooking.setMechanicId(
                    updatedBooking.getMechanicId()
            );

            Booking savedBooking =
                    bookingRepository.save(existingBooking);

            BookingResponse response =
                    new BookingResponse(
                            "Booking updated successfully",
                            savedBooking
                    );

            return new ResponseEntity<>(
                    response,
                    HttpStatus.OK
            );
        }

        BookingResponse response =
                new BookingResponse(
                        "Booking not found for update",
                        null
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    // 5. DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<BookingResponse> deleteBooking(
            @PathVariable Long id) {

        logger.info(
                "Delete request received for booking ID: {}",
                id
        );

        Optional<Booking> booking =
                bookingRepository.findById(id);

        if (booking.isPresent()) {

            bookingRepository.deleteById(id);

            logger.info(
                    "Booking deleted successfully: {}",
                    id
            );

            BookingResponse response =
                    new BookingResponse(
                            "Booking deleted successfully",
                            null
                    );

            return new ResponseEntity<>(
                    response,
                    HttpStatus.OK
            );
        }

        logger.warn(
                "Delete failed. Booking not found with ID: {}",
                id
        );

        BookingResponse response =
                new BookingResponse(
                        "Booking not found",
                        null
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }
}