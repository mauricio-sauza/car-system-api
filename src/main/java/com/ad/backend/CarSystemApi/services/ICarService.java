package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.models.Car;


public interface ICarService {
    public Iterable<Car> getAllCars();
    public void createCar(Car car);
    public void deleteCar(Car car);
    public Car findCarById(Car car);
    public void updateCarById(Car car);
}
