package com.userservice.user_service.dtos;

import com.userservice.user_service.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String paswordHash;

    public static UserResponseDto fromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPaswordHash(user.getPasswordHash());

        return userResponseDto;
    }
}
