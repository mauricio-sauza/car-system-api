package com.ad.backend.CarSystemApi.repositories;

import com.ad.backend.CarSystemApi.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface ICarRepository extends CrudRepository<Car, Long> {

}
