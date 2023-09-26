package com.mustafatatlikatik.stockmanagement.productservice.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
}
