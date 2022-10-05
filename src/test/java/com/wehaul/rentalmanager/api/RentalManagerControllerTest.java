package com.wehaul.rentalmanager.api;

import com.wehaul.rentalmanager.domain.ReservationManagerService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RentalManagerController.class)
class RentalManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationManagerService service;

    @Nested
    class Get {

        @Test
        void shouldReturnAListOfAvailableTrucks() throws Exception {
            when(service.getAvailableTrucks()).thenReturn(List.of("1", "2", "3", "4", "5"));

            mockMvc.perform(get("/api/availabletrucks")
                            .accept(APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json("[\"1\",\"2\",\"3\",\"4\",\"5\"]"));

            verify(service).getAvailableTrucks();
        }

        @Test
        void shouldReserveTruck() throws Exception {
            var reservationId = 3L;

            mockMvc.perform(post("/api/reserve/" + reservationId)
                            .accept(APPLICATION_JSON))
                    .andExpect(status().isOk());

            verify(service).reserve(reservationId);
        }
    }
}
