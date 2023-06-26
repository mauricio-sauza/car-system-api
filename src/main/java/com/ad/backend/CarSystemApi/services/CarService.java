package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.dao.ICarDao;
import com.ad.backend.CarSystemApi.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Service
public class CarService implements ICarService {
    @Autowired
    private ICarDao carDao;

    @Override
    public Iterable<Car> getAllCars() {
        return carDao.findAll();
    }

    @Override
    public Car findCarById(Car car) {
        return carDao.findById(car.getId()).orElse(null);
    }

    @Override
    public Car createCar(@Valid @RequestBody Car car) {
        return carDao.save(car);
    }

    @Override
    public Car updateCarById(Car carId) {
        Car car = carDao.findById(carId.getId()).orElse(null);
        return carDao.save(car);
    }

    @Override
    public Car deleteCar(Car car) {
        Car eliminatedCar = car;
        carDao.delete(car);
        return eliminatedCar;
    }
}
