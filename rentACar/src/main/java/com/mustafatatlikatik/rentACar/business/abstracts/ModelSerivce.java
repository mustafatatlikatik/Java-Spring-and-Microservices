package com.mustafatatlikatik.rentACar.business.abstracts;

import com.mustafatatlikatik.rentACar.business.requests.CreateModelRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllModelsResponse;
import com.mustafatatlikatik.rentACar.entities.concretes.Model;

import java.util.List;
import java.util.Optional;

public interface ModelSerivce {
    List<GetAllModelsResponse> getAll();
    public Optional<List<Model>> getModelName(String name);

    void add(CreateModelRequest createModelRequest);
}
