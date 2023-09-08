package com.mustafatatlikatik.rentACar.dataAccess.abstracts;

import com.mustafatatlikatik.rentACar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
