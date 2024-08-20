package com.example.notuber.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver extends AbstractUser {
    @Embedded
    private Vehicle vehicle;
    @Transient
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DriverStatus status;


}
