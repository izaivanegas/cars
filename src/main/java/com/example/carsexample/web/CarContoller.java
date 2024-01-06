package com.example.carsexample.web;

import com.example.carsexample.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.carsexample.domain.Car;
import java.util.List;
@RestController
@RequestMapping("/cars")
public class CarContoller {

    private final CarService carService;

    public CarContoller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Car> getCar( @PathVariable("id") int id ){
        return carService.getCar(id);
    }



}
