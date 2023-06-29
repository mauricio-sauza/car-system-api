package com.ad.backend.CarSystemApi.controllers;

import com.ad.backend.CarSystemApi.DTO.CarDTO;
import com.ad.backend.CarSystemApi.utils.response.Response;
import com.ad.backend.CarSystemApi.Exceptions.CarNotFoundException;
import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.services.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private ICarService carService;
    @GetMapping()
    public ResponseEntity<ArrayList<Car>> getAll() {
        return ResponseEntity.ok( carService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Car> create(@Valid @RequestBody CarDTO carDto) {
        return new ResponseEntity<>(carService.create(carDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getCarById(@PathVariable("id") Long id) throws CarNotFoundException {
        return ResponseEntity.ok(new Response(HttpStatus.OK.value(), this.carService.findById(id)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable("id") Long id, @RequestBody Car car) throws CarNotFoundException {
        return ResponseEntity.ok(carService.update(id, car));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable("id") Long id) {
        boolean verification = this.carService.delete(id);

        if (verification) {
            return ResponseEntity.ok("Se eliminó el car con id: " + id);
        } else {
            return ResponseEntity.ok("No pudo eliminar el Car con id: " + id);
        }
    }
}
