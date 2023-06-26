package com.ad.backend.CarSystemApi.controllers;

import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public void createCar(@RequestBody Car car) {
        carService.createCar(car);
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(Car car) {
        return carService.findCarById(car);
    }

    @PutMapping("/cars/{id}")
    public void updateCarById(Car car) {
        carService.updateCarById(car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCarById(Car car) {
        carService.deleteCar(car);
    }
}
