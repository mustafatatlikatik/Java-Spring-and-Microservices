package com.mustafatatlikatik.project.hibernateAndJpa.Business;

import com.mustafatatlikatik.project.hibernateAndJpa.Entities.City;

import java.util.List;

public interface ICityService {

    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);

}
