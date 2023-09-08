package com.mustafatatlikatik.rentACar.dataAccess.abstracts;

import com.mustafatatlikatik.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Buraya @Repository yazmamıza gerek yok spring JpaRepository extend olduğu için bu class'ın Repository olduğunu anlıyor
public interface BrandRepository extends JpaRepository<Brand, Integer> { // Entity class hangisiyse onu ve primary id veriyoruz
    boolean existsByName(String name); // spring jpa keywords
    Optional<Brand> findOptionalByName(String name);
}
