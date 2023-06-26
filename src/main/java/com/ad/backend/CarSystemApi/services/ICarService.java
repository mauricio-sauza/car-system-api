package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.models.Car;


public interface ICarService {
    public Iterable<Car> getAllCars();
    public Car createCar(Car car);
    public Car deleteCar(Car car);
    public Car findCarById(Car car);
    public Car updateCarById(Car car);
}
