package com.mustafatatlikatik.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull // Jakarta validation constraints
    @NotBlank // String ifadelere NotBlank, NotNullveya NotEmpty verebiliyoruz
    @Size(min = 1, max = 20)
    private String name;

    @NotNull // Integer ifadelere NotNull verebiliriz sadece
    private int brandId;
}
