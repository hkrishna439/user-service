package com.userservice.user_service.controllers;

import com.userservice.user_service.dtos.UserRegisterRequestDTO;
import com.userservice.user_service.dtos.UserRegisterResponseDTO;
import com.userservice.user_service.models.User;
import com.userservice.user_service.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public UserRegisterResponseDTO registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        User user = userService.register(userRegisterRequestDTO.toUser(userRegisterRequestDTO));

        return UserRegisterResponseDTO.fromUser(user);
    }


}
