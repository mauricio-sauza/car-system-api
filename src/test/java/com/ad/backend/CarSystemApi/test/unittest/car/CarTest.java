//package com.ad.backend.CarSystemApi.test.unittest.car;
//
//import com.ad.backend.CarSystemApi.CarSystemApiApplication;
//import com.ad.backend.CarSystemApi.models.Car;
//import com.ad.backend.CarSystemApi.repositories.ICarRepository;
//import com.ad.backend.CarSystemApi.services.CarService;
//import com.ad.backend.CarSystemApi.services.ICarService;
//import jakarta.transaction.Transactional;
//import org.junit.Assert;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@Transactional
//@SpringBootTest(classes = CarSystemApiApplication.class)
////@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class CarTest {
//    @Autowired
//    private ICarRepository carRepository;
//    @Test
//    @Order(1)
//    public void testGetAlls() {
//        // Arrange
//        Car car = this.getCar();
//        // Act
//         carRepository.save(car);
//        Car found = carRepository.findById(car.getId()).get();
//
//        // Assert
//        Assert.assertEquals(car.getId(), found.getId());
//    }
//
//    private Car getCar() {
//        Car car = new Car();
//        car.setId(1L);
//        car.setBrand("Brand-1");
//        car.setModel("Model-1");
//        car.setColor("Color-1");
//        return car;
//    }
//}
