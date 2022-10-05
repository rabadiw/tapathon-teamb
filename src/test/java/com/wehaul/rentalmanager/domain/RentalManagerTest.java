package com.wehaul.rentalmanager.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RentalManagerTest {

    @Mock
    private IRentalManager rentalManager;

    @Test
    void getAvailableTrucks() {
        when(rentalManager.getAvailableTrucks()).thenReturn(new String[0]);
        var availableTrucks = rentalManager.getAvailableTrucks();
        assertThat(availableTrucks).isEqualTo(new String[0]);
    }
}
