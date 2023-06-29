package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.DTO.CarDTO;
import com.ad.backend.CarSystemApi.Exceptions.CarNotFoundException;
import com.ad.backend.CarSystemApi.models.Car;

import java.util.ArrayList;
import java.util.Optional;


public interface ICarService {
    public ArrayList<Car> getAllCars();
    public Car createCar(CarDTO carDto);
    public boolean deleteCar(Long id);
    public Optional<Car> findCarById(Long id) throws CarNotFoundException;
    public Car updateCarById(Long id, Car car) throws CarNotFoundException;
}
