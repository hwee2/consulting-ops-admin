package com.example.consulting_ops_admin.dto;

public class ApiResponse {

    private final String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

