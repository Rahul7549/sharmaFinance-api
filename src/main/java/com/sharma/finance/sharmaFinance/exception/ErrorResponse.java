package com.sharma.finance.sharmaFinance.exception;


import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.error = error;
       
        this.path = path;
    }

    // Getters and setters
}

