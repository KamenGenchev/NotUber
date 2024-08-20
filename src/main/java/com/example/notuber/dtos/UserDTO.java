package com.example.notuber.dtos;

import com.example.notuber.entities.Ride;

import java.util.List;

public record UserDTO(
        String firstName,
        String lastName,
        String email,
        List<Ride> rideList,
        String telephone
) {
    public List<Ride> getRideList() {
        return List.copyOf(rideList);
    }
}
