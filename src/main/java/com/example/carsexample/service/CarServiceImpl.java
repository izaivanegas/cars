package com.example.carsexample.service;

import com.example.carsexample.domain.Car;
import com.example.carsexample.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }



    @Override
    public List<Car> getAllCarsByColor(String color) {
        return carRepository.findByColor(color);
    }
}
