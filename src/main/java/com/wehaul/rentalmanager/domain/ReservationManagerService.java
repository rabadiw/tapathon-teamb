package com.wehaul.rentalmanager.domain;

import com.wehaul.rentalmanager.data.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Void reserve(Long reservationId) {

        var reservation = repository.findById(reservationId);

        if (reservation.isEmpty()) {
            return null; //todo throw error?
        }


        if (reservation.get().state() == ReservationState.available) {
            var reservationToUpdate = reservation.get();
            reservationToUpdate.setState(ReservationState.reserved);
            repository.save(reservationToUpdate);
            //todo publish event
        } else {
            return null; //todo throw error?
        }


        /*
         try to find reservation record based on truck id
         if it exists and state is available, update state to reserved

         if truck is not available

         if truck id was not found then:
         1 -> create new reservation
         2 -> assign to the reservation
         3 -> save to db
         4 -> publish event
                 resevation{
                  truckId
                 }
        */
        return null;
    }

    public Optional<Reservation> getReservation(Long reservationId) {
        return repository.findById(reservationId);
    }
}
