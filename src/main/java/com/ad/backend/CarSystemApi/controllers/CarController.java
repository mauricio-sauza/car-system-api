package com.ad.backend.CarSystemApi.controllers;

import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CarController {

    @Autowired
    private ICarService carService;
    @GetMapping("/cars")
    @ResponseBody
    public Iterable<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/cars")
    @ResponseBody
    public Car createCar(@Valid @RequestBody Car car) {
        return carService.createCar(car);
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(Car car) {
        return carService.findCarById(car);
    }

    @PutMapping("/cars/{id}")
    public Car updateCarById(@Valid @RequestBody Car car) {
        return carService.updateCarById(car);
    }

    @DeleteMapping("/cars/{id}")
    public Car deleteCarById(Car car) {
        return carService.deleteCar(car);
    }
}
