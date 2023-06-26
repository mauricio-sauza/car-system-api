package com.ad.backend.CarSystemApi.dao;

import com.ad.backend.CarSystemApi.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface ICarDao extends CrudRepository<Car, Long> {

}
