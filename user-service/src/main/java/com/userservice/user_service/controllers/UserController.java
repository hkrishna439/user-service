package com.userservice.user_service.controllers;

import com.userservice.user_service.dtos.UserRegisterRequestDTO;
import com.userservice.user_service.dtos.UserRegisterResponseDTO;
import com.userservice.user_service.dtos.UserResponseDto;
import com.userservice.user_service.models.User;
import com.userservice.user_service.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDTO> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        User user = userService.register(userRegisterRequestDTO.toUser(userRegisterRequestDTO));

        return new ResponseEntity<>(UserRegisterResponseDTO.fromUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String email){
        User user = userService.getUser(email);
        if(user == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(UserResponseDto.fromUser(user), HttpStatus.OK);
    }


}
