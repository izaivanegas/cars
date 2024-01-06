package com.example.carsexample.repository;

import com.example.carsexample.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByYear(int year);
    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByBrandOrColor(String brand, String color);
    List<Car> findByBrandOrderByYearAsc(String brand);

    @Query("select c from Car c where c.brand = ?1 ")
    List<Car> findByBrand();

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);

    Car findById(int id);

}
