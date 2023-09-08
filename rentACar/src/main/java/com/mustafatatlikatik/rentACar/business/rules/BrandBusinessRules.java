package com.mustafatatlikatik.rentACar.business.rules;

import com.mustafatatlikatik.rentACar.core.utilities.exceptions.BusinessException;
import com.mustafatatlikatik.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists"); // Java exception types
        }

    }

}
