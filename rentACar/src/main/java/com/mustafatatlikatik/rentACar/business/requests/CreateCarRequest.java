package com.mustafatatlikatik.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    @NotBlank
    private String plate;

    @NotNull
    private double dailyPrice;

    @NotNull
    private int modelYear;

    @NotNull
    private int state;

    @NotNull
    private int  modelId;
}
