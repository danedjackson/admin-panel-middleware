package com.admin.middleware.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse <T> {
    private HttpStatus httpStatus;
    private T response;
    private String message;
    private LocalDateTime timestamp;

    public ApiResponse(HttpStatus httpStatus, T response, String message) {
        this.httpStatus = httpStatus;
        this.response = response;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
