package com.example.notuber.mapper;

import com.example.notuber.dtos.UserDTO;
import com.example.notuber.entities.User;

public interface UserMapper {
     UserDTO dtoMapper(User user);
}
