package com.ad.backend.CarSystemApi.controllers;

import com.ad.backend.CarSystemApi.DTO.CarDTO;
import com.ad.backend.CarSystemApi.Exceptions.CarNotFoundException;
import com.ad.backend.CarSystemApi.Exceptions.UserNotFoundException;
import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private ICarService carService;
    @GetMapping()
    public ResponseEntity<Iterable<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarDTO carDto) {
        return new ResponseEntity<>(carService.createCar(carDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable("id") Long id) throws CarNotFoundException {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable("id") Long id, @RequestBody Car car) throws UserNotFoundException {
        return ResponseEntity.ok(carService.updateCarById(id, car));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable("id") Long id) {
        boolean verification = this.carService.deleteCar(id);
        if (verification) {
            return ResponseEntity.ok("Se eliminó el car con id: " + id);
        } else {
            return ResponseEntity.ok("No pudo eliminar el Car con id: " + id);
        }
    }
}
