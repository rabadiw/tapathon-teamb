package com.wehaul.rentalmanager.domain;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
public record Reservation(@NotNull Long id, @NotNull Long truckId, ) { }

public enum ReservationState {
    available,
    reserved,
}