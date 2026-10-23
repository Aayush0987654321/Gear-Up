package com.example.car_management.response;

public class BookingResponse {

    private final String message;
    private final Object data;

    public BookingResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}