package com.example.car_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.car_management.entity.Mechanic;
import com.example.car_management.repository.MechanicRepository;
import com.example.car_management.response.MechanicResponse;
import java.util.List;

@RestController
@RequestMapping("/mechanics")
public class MechanicController {

    // LOGGER
    private static final Logger logger =
            LoggerFactory.getLogger(MechanicController.class);

    private final MechanicRepository repository;

    public MechanicController(MechanicRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Mechanic> getAllMechanics() {
        logger.info("Fetching all mechanics");
        return repository.findAll();
    }
    @GetMapping("/{id}")
public Mechanic getMechanicById(@PathVariable Long id) {
    return repository.findById(id).orElse(null);
}


    @PostMapping
public MechanicResponse addMechanic(@RequestBody Mechanic mechanic) {

    Mechanic savedMechanic = repository.save(mechanic);

    return new MechanicResponse(
        "Mechanic added successfully",
        savedMechanic
    );
}
@PutMapping("/{id}")
public Mechanic updateMechanic(@PathVariable Long id, @RequestBody Mechanic updatedMechanic) {

    Mechanic mechanic = repository.findById(id).orElse(null);

    if (mechanic == null) {
        return null;
    }

    mechanic.setMechName(updatedMechanic.getMechName());
    mechanic.setMechPhone(updatedMechanic.getMechPhone());
    mechanic.setMechEmail(updatedMechanic.getMechEmail());
    mechanic.setSkillLevel(updatedMechanic.getSkillLevel());
    mechanic.setSpecialization(updatedMechanic.getSpecialization());
    mechanic.setExperienceYears(updatedMechanic.getExperienceYears());
    mechanic.setAvailabilityStatus(updatedMechanic.getAvailabilityStatus());

    return repository.save(mechanic);
} 
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteMechanic(@PathVariable Long id) {

    if (!repository.existsById(id)) {
        return ResponseEntity.status(404)
                .body("Mechanic not found with ID: " + id);
    }

    repository.deleteById(id);

    logger.info("Mechanic deleted with ID: {}", id);

    return ResponseEntity.ok("Mechanic deleted successfully");
}
    }


