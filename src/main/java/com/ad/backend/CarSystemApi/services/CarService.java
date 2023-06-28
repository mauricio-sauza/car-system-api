package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.DTO.CarDTO;
import com.ad.backend.CarSystemApi.Exceptions.CarNotFoundException;
import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;


@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository carRepository;

    @Override
    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findCarById(Long id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) return car;
        else {
            throw new CarNotFoundException("Car not found with id: " + id);
        }
    }

    @Override
    public Car createCar(CarDTO carDto) {
        Car car = Car.build(1L, carDto.getBrand(), carDto.getModel(), carDto.getColor());
        return carRepository.save(car);
    }

    @Override
    public Car updateCarById(Long id, Car car) throws CarNotFoundException {
        if(!carRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }
        return carRepository.findById(id).map(oldCar-> {
            oldCar.setBrand(car.getBrand());
            oldCar.setModel(car.getModel());
            oldCar.setColor(car.getColor());
            return carRepository.save(oldCar);
        }).orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
    }

    @Override
    public boolean deleteCar(Long id) {
        try {
            carRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
