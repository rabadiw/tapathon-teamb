package com.wehaul.rentalmanager.data;

import com.wehaul.rentalmanager.domain.Reservation;
import com.wehaul.rentalmanager.domain.NewCustomerProfile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReservationRepository {

    private final CustomerProfileJpaRepository jpaRepository;

    public ReservationRepository(CustomerProfileJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Reservation create(NewCustomerProfile newCustomerProfile) {
        var savedEntity = jpaRepository.save(toEntity(newCustomerProfile));
        return fromEntity(savedEntity);
    }

    public Optional<Reservation> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::fromEntity);
    }

    private CustomerProfileEntity toEntity(NewCustomerProfile newCustomerProfile) {
        var entity = new CustomerProfileEntity();
        entity.setFirstName(newCustomerProfile.firstName());
        entity.setLastName(newCustomerProfile.lastName());
        entity.setEmail(newCustomerProfile.email());
        return entity;
    }

    private Reservation fromEntity(CustomerProfileEntity entity) {
        return new Reservation(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail());
    }
}
