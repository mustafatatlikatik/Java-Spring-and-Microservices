package com.mustafatatlikatik.rentACar.business.concretes;

import com.mustafatatlikatik.rentACar.business.abstracts.CarService;
import com.mustafatatlikatik.rentACar.business.requests.CreateCarRequest;
import com.mustafatatlikatik.rentACar.business.responses.GetAllCarsResponse;
import com.mustafatatlikatik.rentACar.business.responses.GetAllModelsResponse;
import com.mustafatatlikatik.rentACar.core.utilities.mappers.ModelMapperManager;
import com.mustafatatlikatik.rentACar.dataAccess.abstracts.CarRepository;
import com.mustafatatlikatik.rentACar.dataAccess.abstracts.ModelRepository;
import com.mustafatatlikatik.rentACar.entities.concretes.Car;
import com.mustafatatlikatik.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private BrandManager brandManager;
    private CarRepository carRepository;
    private ModelMapperManager modelMapperService;
    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> carsResponse = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
        return carsResponse;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
        this.carRepository.save(car);
    }

}
