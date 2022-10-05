package com.wehaul.rentalmanager.data;

import com.wehaul.rentalmanager.domain.NewCustomerProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.wehaul.rentalmanager.domain.TestData.testNewCustomerProfile;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository subject;

    @Test
	void shouldPersistCustomerProfile() {
		NewCustomerProfile newCustomerProfile = testNewCustomerProfile();

		var customerProfile = subject.create(newCustomerProfile);
		var actual = subject.findById(customerProfile.id());

		var actualEntity = actual.get();
		assertThat(actualEntity.firstName()).isEqualTo(customerProfile.firstName());
		assertThat(actualEntity.lastName()).isEqualTo(customerProfile.lastName());
		assertThat(actualEntity.email()).isEqualTo(customerProfile.email());
	}
}
