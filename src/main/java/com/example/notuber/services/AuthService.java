package com.example.notuber.services;

import com.example.notuber.dtos.UserRegisterDTO;
import com.example.notuber.entities.User;
import com.example.notuber.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;


    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRegisterDTO dto) {
        User user = new User();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setPassword(dto.password()); //TODO: Ideally, you should hash the password before saving to DB.
        userRepository.save(user);
        return user;
    }
}
