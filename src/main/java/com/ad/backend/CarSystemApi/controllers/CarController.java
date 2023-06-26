package com.ad.backend.CarSystemApi.controllers;

import com.ad.backend.CarSystemApi.dao.ICarDao;
import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private ICarService carService;
    @GetMapping("/cars")
    @ResponseBody
    public Iterable<Car> getAllCars() {
        var cars = carService.getAllCars();
        return cars;
    }

    @PostMapping("/cars")
    public void getCarsById(Car car) {
        carService.createCar(car);
    }
}
