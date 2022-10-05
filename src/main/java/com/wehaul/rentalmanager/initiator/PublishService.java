package com.wehaul.rentalmanager.initiator;

import com.wehaul.rentalmanager.domain.Reservation;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    private final StreamBridge streamBridge;

    public PublishService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void publishReservation(String type, Reservation reservation) {
        streamBridge.send(type, reservation);
    }
}

