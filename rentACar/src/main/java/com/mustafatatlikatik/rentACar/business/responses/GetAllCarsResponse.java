package com.mustafatatlikatik.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
    private int id;
    private String brandName;
    private String plate;
    private double dalilyPrice;
    private int modelYear;
    private int state;
    private String modelName;
}
