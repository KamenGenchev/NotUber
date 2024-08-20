package com.example.notuber.dtos;

public record UserRegisterDTO(
        String firstName,
        String lastName,
        String email,
        String password

) {
}
