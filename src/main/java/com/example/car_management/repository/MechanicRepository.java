package com.example.car_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.car_management.entity.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

}