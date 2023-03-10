package com.carsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.dto.CarDTO;
import com.carsapi.model.Car;
import com.carsapi.repository.CarRepository;

@RestController
@RequestMapping("/car")
public class CarController {

  @Autowired
  private CarRepository repository;

  @GetMapping
  public List<Car> findAll() {
    return repository.findAll();
  }

  @PostMapping
  public void create(@RequestBody CarDTO reqCarDTO) {
    repository.save(new Car(reqCarDTO));
    System.out.println("Adicionado carro:");
    System.out.println(reqCarDTO.modelo());
    System.out.println(reqCarDTO.anoModelo());
  }
}
