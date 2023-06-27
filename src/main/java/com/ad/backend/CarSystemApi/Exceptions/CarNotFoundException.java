package com.ad.backend.CarSystemApi.Exceptions;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
}
