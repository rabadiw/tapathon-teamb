package com.wehaul.rentalmanager.initiator;

import com.wehaul.rentalmanager.domain.Reservation;
import com.wehaul.rentalmanager.domain.ReservationState;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    private final StreamBridge streamBridge;

    public PublishService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public Reservation generate(String type) {
        Reservation reservation = new Reservation(3L, 7L, ReservationState.reserved);
        streamBridge.send(type, reservation);
        return reservation;
    }
}

