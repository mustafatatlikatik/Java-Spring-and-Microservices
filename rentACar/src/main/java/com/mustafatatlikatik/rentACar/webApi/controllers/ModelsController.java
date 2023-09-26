package com.mustafatatlikatik.rentACar.webApi.controllers;

import com.mustafatatlikatik.rentACar.business.abstracts.ModelSerivce;
import com.mustafatatlikatik.rentACar.business.requests.CreateModelRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllModelsResponse;
import com.mustafatatlikatik.rentACar.entities.concretes.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelSerivce modelSerivce;
    @GetMapping("/getAll")
    public List<GetAllModelsResponse> getAll(){
        return modelSerivce.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){
        this.modelSerivce.add(createModelRequest);
    }
    @GetMapping("/getByModelName")
    public Optional<List<Model>> getByModelName(String name){
        return modelSerivce.getModelName(name);
    }
}