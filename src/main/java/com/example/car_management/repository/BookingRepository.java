package com.example.car_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.car_management.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}