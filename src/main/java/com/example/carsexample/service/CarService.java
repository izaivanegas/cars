package com.example.carsexample.service;

import com.example.carsexample.domain.Car;
import com.example.carsexample.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {

    public List<Car> getAllCars();
    public List<Car> getAllCarsByColor(String color);
    public ResponseEntity<Car> getCar(Integer id);

    /**
     * Se guarda un auto en la base de datos
     * @param car
     * @return
     */
    public ResponseEntity addCar(Car car);

    /**
     * Borrar un auto
     * @param id
     * @return
     */
    public ResponseEntity deleteCar(Integer id);

    /**
     * Actualizar la informacion de un auto
     * @param id
     * @return
     */
    public ResponseEntity updateCar(Integer id, Car car);



}
