package com.wehaul.rentalmanager.data;

import com.wehaul.rentalmanager.domain.Reservation;
import com.wehaul.rentalmanager.domain.ReservationState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByState(ReservationState available);
}
