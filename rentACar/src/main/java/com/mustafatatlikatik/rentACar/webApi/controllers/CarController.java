package com.mustafatatlikatik.rentACar.webApi.controllers;

import com.mustafatatlikatik.rentACar.business.abstracts.CarService;
import com.mustafatatlikatik.rentACar.business.requests.CreateCarRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllCarsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @GetMapping("/gelAllCars")
    public List<GetAllCarsResponse> getAll(){
        return carService.getAll();
    }
    @PostMapping("/addCars")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }

}
