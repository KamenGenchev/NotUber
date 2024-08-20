package com.example.notuber.entities;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Struct;

@Embeddable
@Struct(name = "DriverVehicle")
public record Vehicle(
        String make,
        String model,
        String licenceNumber) {
}
