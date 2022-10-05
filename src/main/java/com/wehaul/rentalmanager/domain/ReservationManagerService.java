package com.wehaul.rentalmanager.domain;

import com.wehaul.rentalmanager.data.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ReservationManagerService {
    private final ReservationRepository repository;

//    private final CustomerProfileRepository repository;

    public ReservationManagerService(ReservationRepository repository) {
        this.repository = repository;
    }

//    @Transactional
//    public CustomerProfile create(NewCustomerProfile newCustomerProfile) {
//        return repository.create(newCustomerProfile);
//    }
//
//    public Optional<CustomerProfile> getById(Long id) {
//        return repository.findById(id);
//    }

    public List<String> getAvailableTrucks() {
        return repository.findByState(ReservationState.available).stream()
                .map(Reservation::id)
                .map(Object::toString)
                .toList();
    }
}
