package com.wehaul.rentalmanager.api;

import com.wehaul.rentalmanager.domain.ReservationManagerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@OpenAPIDefinition(
        info = @Info(
                title = "Rental Manager API",
                version = "1.0"),
        tags = @Tag(
                name = "Rental Manager REST API"))
@CrossOrigin
@RestController
@RequestMapping("/api/")
class RentalManagerController {

    private final ReservationManagerService service;

    RentalManagerController(ReservationManagerService service) {
        this.service = service;
    }

    @GetMapping("/availabletrucks")
    ResponseEntity<List<String>> getAvailableTrucks() {
        return ok(service.getAvailableTrucks());
    }

    @PostMapping("/reserve/{reservationId}")
    ResponseEntity<Void> reserve(@PathVariable("reservationId") Long reservationId) {
        return ok(service.reserve(reservationId));
    }

}
