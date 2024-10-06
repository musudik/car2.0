package com.car.market.controller;

import com.car.market.entity.Car;
import com.car.market.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car-market/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Car getCarDetails(@PathVariable("id") Integer id) {
        Optional<Car> carOptional = carService.getCarDetails(id);
        return carOptional.orElse(null);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @DeleteMapping
    public void deleteCar(@RequestBody Car car) {
        carService.deleteCar(car);
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car updatedCar) {
        Optional<Car> carOptional = carService.getCarDetails(updatedCar.getId());

        if (carOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        /*Car existingCar = carOptional.get();

        existingCar.setMake(updatedCar.getMake());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setYear(updatedCar.getYear());
        existingCar.setColor(updatedCar.getColor());
        existingCar.setFuel(updatedCar.getFuel());
        existingCar.setDescription(updatedCar.getDescription());
        existingCar.setMileage(updatedCar.getMileage());
        existingCar.setGearType(updatedCar.getGearType());
        existingCar.setImage(updatedCar.getImage());
        existingCar.setPower(updatedCar.getPower());
        existingCar.setPrice(updatedCar.getPrice());
        existingCar.setStatus(updatedCar.getStatus());*/

        return ResponseEntity.ok(carService.addCar(updatedCar));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCar(@PathVariable Integer id) {
        Optional<Car> carOptional = carService.getCarDetails(id);

        if (carOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Car existingCar = carOptional.get();
        carService.deleteCar(existingCar);

        return ResponseEntity.ok("Successfully deleted car: "+id);
    }
}