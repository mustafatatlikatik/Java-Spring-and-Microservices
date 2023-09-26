package com.mustafatatlikatik.stockmanagement.productcacheservice.service;

import com.mustafatatlikatik.stockmanagement.productcacheservice.enums.Language;
import com.mustafatatlikatik.stockmanagement.productcacheservice.repository.entity.Product;

public interface ProductRepositoryService {

    Product getProduct(Language language, Long productId);

    void deleteProducts(Language language);
}
