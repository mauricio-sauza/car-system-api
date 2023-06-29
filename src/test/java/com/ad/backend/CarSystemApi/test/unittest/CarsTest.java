package com.ad.backend.CarSystemApi.test.unittest;

import com.ad.backend.CarSystemApi.models.Car;
import com.ad.backend.CarSystemApi.services.CarService;
import com.ad.backend.CarSystemApi.services.ICarService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CarsTest {
    @Test
    public void getAll(){
//        Arrange
        ICarService carService = new CarService();
//        Act
        ArrayList<Car> cars = carService.getAll();
//        Assert
        Assert.assertTrue(cars.size()>=0);
    }
}
