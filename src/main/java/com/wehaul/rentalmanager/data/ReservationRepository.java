package com.wehaul.rentalmanager.data;

import com.wehaul.rentalmanager.domain.Reservation;
import com.wehaul.rentalmanager.domain.ReservationState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long reservationId);

    List<Reservation> findByState(ReservationState available);

}
