package com.mustafatatlikatik.rentACar.business.concretes;

import com.mustafatatlikatik.rentACar.business.abstracts.BrandService;
import com.mustafatatlikatik.rentACar.business.requests.CreateBrandRequest;
import com.mustafatatlikatik.rentACar.business.requests.UpdateBrandRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllBrandsResponse;
import com.mustafatatlikatik.rentACar.business.responses.GetByIdBrandResponse;
import com.mustafatatlikatik.rentACar.business.rules.BrandBusinessRules;
import com.mustafatatlikatik.rentACar.core.utilities.exceptions.BusinessException;
import com.mustafatatlikatik.rentACar.core.utilities.mappers.ModelMapperService;
import com.mustafatatlikatik.rentACar.dataAccess.abstracts.BrandRepository;
import com.mustafatatlikatik.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//IoC = Inversion of Control
@Service // Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Optional<Brand> brand = this.brandRepository.findById(id);

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public Optional<Brand> findByBrandName(String name) {

        Optional<Brand> optionalBrand = brandRepository.findOptionalByName(name);

        if (optionalBrand.isEmpty()){
            throw new BusinessException("Brand name is empty");
        }
        return optionalBrand;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequests) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequests.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequests, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }


}