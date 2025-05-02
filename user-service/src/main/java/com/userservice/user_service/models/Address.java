package com.userservice.user_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "address")
public class Address extends BaseModel{
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private boolean primaryAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
