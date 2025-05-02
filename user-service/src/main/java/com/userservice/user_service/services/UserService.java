package com.userservice.user_service.services;

import com.userservice.user_service.exceptions.EmailAlreadyExistsException;
import com.userservice.user_service.models.Role;
import com.userservice.user_service.models.User;
import com.userservice.user_service.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User register(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: "+ user.getEmail());
        }

        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));
        user.setRole(Role.USER);
        userRepository.save(user);

        return user;
    }

    public User getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        return user.orElse(null);

    }
}
