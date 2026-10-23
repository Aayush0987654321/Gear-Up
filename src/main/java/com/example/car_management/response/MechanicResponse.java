package com.example.car_management.response;

import com.example.car_management.entity.Mechanic;

public class MechanicResponse {

    private String message;
    private Mechanic data;

    public MechanicResponse() {
    }

    public MechanicResponse(String message, Mechanic data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Mechanic getData() {
        return data;
    }

    public void setData(Mechanic data) {
        this.data = data;
    }
}