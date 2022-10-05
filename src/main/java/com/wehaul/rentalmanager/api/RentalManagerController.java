package com.wehaul.rentalmanager.api;

import com.wehaul.rentalmanager.domain.ReservationManagerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @Operation(summary = "Saves provided customer profile.", method = "POST", tags = "Customer Profile CRUD")
//    @ApiResponses({
//            @ApiResponse(
//                    responseCode = "201",
//                    description = "Customer profile successfully saved.",
//                    headers = @Header(
//                            name = "Location",
//                            description = "Contains path which can be used to retrieve saved profile. Last element is it's ID.",
//                            required = true,
//                            schema = @Schema(type = "string"))
//            ),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "Passed customer profile is invalid."
//            )
//    })
//    @PostMapping("")
//    ResponseEntity<Void> create(@Valid @RequestBody CustomerProfileCreateRequest request) {
//        var newCustomerProfile = fromRequest(request);
//
//        var customerProfile = service.create(newCustomerProfile);
//
//        return ResponseEntity.created(toLocationUri(customerProfile.id())).build();
//    }

    //    @Operation(summary = "Get customer profile.", method = "GET", tags = "Customer Profile CRUD")
//    @ApiResponses({
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "Customer profile retrieved successfully."
//            ),
//            @ApiResponse(
//                    responseCode = "404",
//                    description = "Customer profile not found."
//            )
//    })
    @GetMapping("/availabletrucks")
    ResponseEntity<List<String>> getAvailableTrucks() {
        return ok(service.getAvailableTrucks());
    }

//    private CustomerProfileResponse toResponse(CustomerProfile customerProfile) {
//        return new CustomerProfileResponse(
//                customerProfile.id(),
//                customerProfile.firstName(),
//                customerProfile.lastName(),
//                customerProfile.email()
//        );
//    }
//
//    private static NewCustomerProfile fromRequest(CustomerProfileCreateRequest request) {
//        return new NewCustomerProfile(
//                request.firstName(),
//                request.lastName(),
//                request.email()
//        );
//    }
//
//    private URI toLocationUri(Long id) {
//        return ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(id)
//                .toUri();
//    }
}
