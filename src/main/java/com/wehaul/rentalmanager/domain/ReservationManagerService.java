package com.wehaul.rentalmanager.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReservationManagerService {

//    private final CustomerProfileRepository repository;

//    public ReservationManagerService(CustomerProfileRepository repository) {
//        this.repository = repository;
//    }

//    @Transactional
//    public CustomerProfile create(NewCustomerProfile newCustomerProfile) {
//        return repository.create(newCustomerProfile);
//    }
//
//    public Optional<CustomerProfile> getById(Long id) {
//        return repository.findById(id);
//    }

    public List<String> getAvailableTrucks() {
        return new ArrayList<>();
    }
}
