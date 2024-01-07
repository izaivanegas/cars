package com.example.carsexample.service;

import com.example.carsexample.domain.Car;
import com.example.carsexample.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    private HashMap datos;

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

    @Override
    public ResponseEntity getCar(Integer id) {
        Car carResult = null;
        datos = new HashMap<>();
        HttpStatus statusFinal = HttpStatus.CONFLICT;
        datos.put("error",true);
        if( id != null  ){
            carResult = carRepository.findById(id).get();
            if( carResult != null ){
                statusFinal = HttpStatus.ACCEPTED;
                datos.put("error",false);
                datos.put("message","");
                datos.put("data",carResult);
            }else{
                datos.put("message","Problemas con la recuperacion en la base de datos");
            }
        }else{
            datos.put("message","No esta en la base de datos");
        }
        return  new ResponseEntity<>(datos,statusFinal);
    }

    @Override
    public ResponseEntity addCar(Car car) {
        log.info("addCar..........");
        datos = new HashMap<>();
        datos.put("error",true);
        datos.put("message","No se ha recibido la informacion del auto");
        datos.put("data",null);
        HttpStatus statusFinal = HttpStatus.CONFLICT;
        Car carResultado = null;
        if(car != null){
            carResultado = carRepository.save(car);
            datos.put("error",false);
            datos.put("message","Se ha guardado el objeto");
            statusFinal = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<>(datos,statusFinal);
    }
}
