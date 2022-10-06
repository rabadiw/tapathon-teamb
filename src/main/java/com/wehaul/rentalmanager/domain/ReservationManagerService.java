package com.wehaul.rentalmanager.domain;

import com.wehaul.rentalmanager.data.ReservationRepository;
import com.wehaul.rentalmanager.initiator.PublishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationManagerService {
    private final ReservationRepository repository;

    private final PublishService publishService;

    public ReservationManagerService(ReservationRepository repository, PublishService publishService) {

        this.repository = repository;
        this.publishService = publishService;
    }

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
//            publishService.publishReservation("reserved", updatedReservation);
        } else {
            return null; //todo throw error?
        }

        return null;
    }

    //event type: pickedUp
    // send {truckId, miles, state}

    //event type: fulfilled

    public Optional<Reservation> getReservation(Long reservationId) {
        return repository.findById(reservationId);
    }
}
