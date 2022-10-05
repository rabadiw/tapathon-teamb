package com.wehaul.rentalmanager.domain;

import com.wehaul.rentalmanager.data.ReservationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationManagerServiceTest {

    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationManagerService subject;

    @Test
    void shouldDelegateToRepositoryToRetrieveAvailableTrucks() {
        var reservations = List.of(
                new Reservation(1L, 1L, ReservationState.available),
                new Reservation(3L, 3L, ReservationState.available)
        );
        when(repository.findByState(ReservationState.available)).thenReturn(reservations);

        var result = subject.getAvailableTrucks();

        Assertions.assertThat(result).isEqualTo(List.of("1", "3"));
        verify(repository).findByState(ReservationState.available);
    }
}
