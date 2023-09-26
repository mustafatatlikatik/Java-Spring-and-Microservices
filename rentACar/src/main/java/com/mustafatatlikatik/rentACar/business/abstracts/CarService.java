package com.mustafatatlikatik.rentACar.business.abstracts;

import com.mustafatatlikatik.rentACar.business.requests.CreateCarRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllCarsResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();

    void add(CreateCarRequest createCarRequest);
}
