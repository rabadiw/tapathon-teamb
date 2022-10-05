package com.wehaul.rentalmanager.domain;

import com.wehaul.rentalmanager.data.CustomerProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileService(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CustomerProfile create(NewCustomerProfile newCustomerProfile) {
        return repository.create(newCustomerProfile);
    }

    public Optional<CustomerProfile> getById(Long id) {
        return repository.findById(id);
    }
}
