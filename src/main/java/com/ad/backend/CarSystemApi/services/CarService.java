package com.ad.backend.CarSystemApi.services;

import com.ad.backend.CarSystemApi.dao.ICarDao;
import com.ad.backend.CarSystemApi.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public void createCar(Car car) {
        carDao.save(car);
    }

    @Override
    public void updateCarById(Car carId) {
        Car car = carDao.findById(carId.getId()).orElse(null);
        carDao.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carDao.delete(car);
    }
}
