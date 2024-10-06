package com.car.market.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString
public class ErrorResponse {

    HttpStatus httpStatus;
    String message;
}
