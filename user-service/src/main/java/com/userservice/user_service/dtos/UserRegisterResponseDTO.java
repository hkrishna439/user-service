package com.userservice.user_service.dtos;

import com.userservice.user_service.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterResponseDTO {
    private Long id;
    private String message;

    public UserRegisterResponseDTO(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public static UserRegisterResponseDTO fromUser(User user) {
        return new UserRegisterResponseDTO(user.getId(), "User registered successfully");
    }
}
