package com.mustafatatlikatik.rentACar.dataAccess.abstracts;

import com.mustafatatlikatik.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model,Integer>{

    Optional<List<Model>> findOptionalByBrandId(int id);

}
