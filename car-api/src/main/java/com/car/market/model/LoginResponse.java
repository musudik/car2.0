package com.car.market.model;

import com.car.market.entity.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginResponse {

    private String token;
    private long expiresIn;
    private User user;
}
