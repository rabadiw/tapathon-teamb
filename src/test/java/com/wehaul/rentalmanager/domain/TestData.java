package com.wehaul.rentalmanager.domain;

public class TestData {

    public static Reservation testReservation() {
        return new Reservation(123L, );
    }

    public static NewCustomerProfile testNewCustomerProfile() {
        return new NewCustomerProfile("Joe", "Doe", "joe.doe@test.org");
    }
}
