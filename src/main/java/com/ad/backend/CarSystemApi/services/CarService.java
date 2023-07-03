package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.DTO.CarDTO;
import com.ad.backend.CarSystemApi.Exceptions.CarNotFoundException;
import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Optional;


@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository carRepository;

    @Override
    public ArrayList<Car> getAll() {
        return (ArrayList<Car>)  this.carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) return car;
        else {
            throw new ResourceNotFoundException("Car not found with id: " + id);
        }
    }

    @Override
    public Car create(CarDTO carDto) {
        Car car = Car.build(null, carDto.getBrand(), carDto.getModel(), carDto.getColor());
        return carRepository.save(car);
    }

    @Override
    public Car update(Long id, Car car) throws CarNotFoundException {
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
    public boolean delete(Long id) {
        try {
            carRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
