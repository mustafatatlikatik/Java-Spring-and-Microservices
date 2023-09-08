package com.mustafatatlikatik.rentACar.business.abstracts;

import com.mustafatatlikatik.rentACar.business.requests.CreateBrandRequest;
import com.mustafatatlikatik.rentACar.business.requests.UpdateBrandRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllBrandsResponse;
import com.mustafatatlikatik.rentACar.business.responses.GetByIdBrandResponse;
import com.mustafatatlikatik.rentACar.entities.concretes.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);

    Optional<Brand> findByBrandName(String name);

    void add(CreateBrandRequest createBrandRequests);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);


}
