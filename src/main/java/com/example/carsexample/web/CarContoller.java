package com.example.carsexample.web;

import com.example.carsexample.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.carsexample.domain.Car;
import java.util.List;
@RestController
@RequestMapping("/cars")
@Slf4j
public class CarContoller {

    private final CarService carService;

    public CarContoller(CarService carService) {
        this.carService = carService;
    }

    /**
     * Se recuperan todos los elementos de la tabla de autos
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        log.info("getAllCars - controller");
        return ResponseEntity.ok(carService.getAllCars());
    }

    /**
     * Se recupera un auto en particular
     * @param id
     * @return
     */
    @GetMapping(path = "{id}")
    public ResponseEntity<Car> getCar( @PathVariable("id") int id ){
        log.info("getCar by id");
        return carService.getCar(id);
    }

    /**
     * Se agrega un auto
     * @param car
     * @return
     */
    @PostMapping( "/add")
    public ResponseEntity addCar( @RequestBody Car car ){
        log.info("addCar in controller......");
        return carService.addCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id){
        log.info("Delete car");
        return carService.deleteCar(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCar(@PathVariable("id") int id, @RequestBody Car car){
        return carService.updateCar(id, car);
    }

}
