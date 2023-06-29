package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.DTO.CarDTO;
import com.ad.backend.CarSystemApi.Exceptions.CarNotFoundException;
import com.ad.backend.CarSystemApi.models.Car;

import java.util.ArrayList;
import java.util.Optional;


public interface ICarService {
    public ArrayList<Car> getAll();
    public Car create(CarDTO carDto);
    public boolean delete(Long id);
    public Optional<Car> findById(Long id) throws CarNotFoundException;
    public Car update(Long id, Car car) throws CarNotFoundException;
}
