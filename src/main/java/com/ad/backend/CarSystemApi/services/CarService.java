package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.DTO.CarDTO;
import com.ad.backend.CarSystemApi.dao.ICarDao;
import com.ad.backend.CarSystemApi.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CarService implements ICarService {
    @Autowired
    private ICarDao carDao;

    @Override
    public Iterable<Car> getAllCars() {
        return carDao.findAll();
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        Optional<Car> car = carDao.findById(id);
        if(car.isPresent()) return car;
        else {
            throw new ResourceNotFoundException("Car not found with id: " + id);
        }
    }

    @Override
    public Car createCar(CarDTO carDto) {
        Car car = Car.build(1L, carDto.getBrand(), carDto.getModel(), carDto.getColor());
        return carDao.save(car);
    }

    @Override
    public Car updateCarById(Long id, Car car) {
        if(!carDao.existsById(id)) {
            throw new ResourceNotFoundException("Car not found with id: " + id);
        }
        return carDao.findById(id).map(oldCar-> {
            oldCar.setBrand(car.getBrand());
            oldCar.setModel(car.getModel());
            oldCar.setColor(car.getColor());
            return carDao.save(oldCar);
        }).orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
    }

    @Override
    public boolean deleteCar(Long id) {
        try {
            carDao.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
