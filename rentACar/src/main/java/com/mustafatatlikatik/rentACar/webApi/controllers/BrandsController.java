package com.mustafatatlikatik.rentACar.webApi.controllers;

import com.mustafatatlikatik.rentACar.business.abstracts.BrandService;
import com.mustafatatlikatik.rentACar.business.requests.CreateBrandRequest;
import com.mustafatatlikatik.rentACar.business.requests.UpdateBrandRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllBrandsResponse;
import com.mustafatatlikatik.rentACar.business.responses.GetByIdBrandResponse;
import com.mustafatatlikatik.rentACar.entities.concretes.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController // Annotation
@RequestMapping("/api/brands") // "/api/brands" tarayıcıdaki adresleme çubuğundaki gördüklerimiz
@AllArgsConstructor
public class BrandsController { // Brand(s) dememizin sebebi api isimlendirmeleri çoğul yazılır
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }
    @GetMapping("/findByName")
    public Optional<Brand> brandFindByName(String name){
        return brandService.findByBrandName(name);
    }


    @GetMapping("/{id}") //request mapping'den alıyor id'yi
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequests) {
        this.brandService.add(createBrandRequests);
    }

    @PutMapping
    public void Update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id) {
        this.brandService.delete(id);
    }

}
