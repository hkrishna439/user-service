package com.userservice.user_service.dtos;

import com.userservice.user_service.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String password;

    public User toUser(UserRegisterRequestDTO userRegisterRequestDTO) {
        User user = new User();
        user.setName(userRegisterRequestDTO.getName());
        user.setEmail(userRegisterRequestDTO.getEmail());
        user.setPhone(userRegisterRequestDTO.getPhone());
        user.setPasswordHash(userRegisterRequestDTO.getPassword());

        return user;
    }
}
