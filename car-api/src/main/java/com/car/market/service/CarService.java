package com.car.market.service;


import com.car.market.entity.Car;
import com.car.market.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarDetails(Integer id) {
        return carRepository.findById(id);
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Car car) {
        carRepository.deleteById(car.getId());
    }

    public Car updateCar(Car car) {
        return addCar(car);
    }
}
