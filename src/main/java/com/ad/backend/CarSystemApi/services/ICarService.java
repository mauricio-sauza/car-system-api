package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.models.Car;

import java.util.List;


public interface ICarService {
    public Iterable<Car> getAllCars();
    public void createCar(Car car);
    public void deleteCar(Car car);
    public Car findCarById(Car car);
}
