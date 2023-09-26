package com.mustafatatlikatik.rentACar.business.concretes;

import com.mustafatatlikatik.rentACar.business.abstracts.ModelSerivce;
import com.mustafatatlikatik.rentACar.business.requests.CreateModelRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllModelsResponse;
import com.mustafatatlikatik.rentACar.core.utilities.exceptions.BusinessException;
import com.mustafatatlikatik.rentACar.core.utilities.mappers.ModelMapperManager;
import com.mustafatatlikatik.rentACar.dataAccess.abstracts.ModelRepository;
import com.mustafatatlikatik.rentACar.entities.concretes.Brand;
import com.mustafatatlikatik.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelSerivce {
    private ModelRepository modelRepository;
    private ModelMapperManager modelMapperService;
    private BrandManager brandManager;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
    @Override
    public Optional<List<Model>> getModelName(String name){
        Optional<Brand> optionalBrand = brandManager.findByBrandName(name);

        if (optionalBrand.isEmpty()){
            throw new BusinessException("Brand name is empty");
        }
        return modelRepository.findOptionalByBrandId(optionalBrand.get().getId());

    }
}