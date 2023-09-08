package com.mustafatatlikatik.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //hem getter hem setter görevi görür
@AllArgsConstructor
@NoArgsConstructor

public class GetAllBrandsResponse {
    private int id;
    private String name;
}
