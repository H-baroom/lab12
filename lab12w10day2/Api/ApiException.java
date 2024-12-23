package com.example.lab12w10day2.Api;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
