package com.wehaul.rentalmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotNull Long truckId;
    private ReservationState state;

    public Reservation(@NotNull Long id, @NotNull Long truckId, ReservationState state) {
        this.id = id;
        this.truckId = truckId;
        this.state = state;
    }

    public Reservation() {

    }

    public @NotNull Long id() {
        return id;
    }

    public @NotNull Long truckId() {
        return truckId;
    }

    public ReservationState state() {
        return state;
    }

    public void setState(ReservationState state) {
        this.state = state;
    }

}

