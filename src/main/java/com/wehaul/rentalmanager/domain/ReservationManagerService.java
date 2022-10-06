package com.wehaul.rentalmanager.domain;

import com.wehaul.rentalmanager.data.ReservationRepository;
import com.wehaul.rentalmanager.initiator.PublishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ReservationManagerService {
    private final ReservationRepository repository;

    private final PublishService publishService;

    public ReservationManagerService(ReservationRepository repository, PublishService publishService) {

        this.repository = repository;
        this.publishService = publishService;
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
                .map(Reservation::getId)
                .map(Object::toString)
                .toList();
    }

    public Void reserve(Long reservationId) {

        var reservation = repository.findById(reservationId);

        if (reservation.isEmpty()) {
            return null; //todo throw error?
        }


        if (reservation.get().getState() == ReservationState.available) {
            var updatedReservation = reservation.get();
            updatedReservation.setState(ReservationState.reserved);
            repository.save(updatedReservation);
            publishService.publishReservation("reserved", updatedReservation);
        } else {
            return null; //todo throw error?
        }

        return null;
    }

    public Optional<Reservation> getReservation(Long reservationId) {
        return repository.findById(reservationId);
    }
}
