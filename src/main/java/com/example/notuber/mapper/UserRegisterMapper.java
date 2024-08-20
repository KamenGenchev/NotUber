package com.example.notuber.mapper;

import com.example.notuber.dtos.UserDTO;
import com.example.notuber.dtos.UserRegisterDTO;
import com.example.notuber.entities.User;

public class UserRegisterMapper implements UserMapper{
    public static UserRegisterDTO userToRegisterDto(User user) {
        return new UserRegisterDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public UserDTO dtoMapper(User user) {
        return new UserRegisterDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
