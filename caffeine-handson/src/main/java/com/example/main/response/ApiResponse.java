package com.example.main.response;

public class ApiResponse {
    private String status;
    private String message;
    private String uuid;

    public ApiResponse(String status, String message, String uuid) {
        this.status = status;
        this.message = message;
        this.message = uuid;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}