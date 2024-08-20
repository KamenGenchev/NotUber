package com.example.notuber.services;

import com.example.notuber.entities.User;
import com.example.notuber.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Transactional
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User save(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());

        userOptional.ifPresentOrElse(
                existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setEmail(user.getEmail());
                    userRepository.save(existingUser);
                },
                () -> userRepository.save(user)
        );

        return user;
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}