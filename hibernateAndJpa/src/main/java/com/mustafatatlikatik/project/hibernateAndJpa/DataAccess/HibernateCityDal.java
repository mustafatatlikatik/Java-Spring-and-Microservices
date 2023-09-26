package com.mustafatatlikatik.project.hibernateAndJpa.DataAccess;

import com.mustafatatlikatik.project.hibernateAndJpa.Entities.City;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//JPA - ORM
@Repository
public class HibernateCityDal implements ICityDal {

    private EntityManager entityManager;
    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<City> getAll() {
      Session session = entityManager.unwrap(Session.class);
      List<City> cities = session.createQuery("from City c where c.countryCode='TUR'",City.class).getResultList();
      return cities ;
    }

    @Override
    @Transactional
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);

    }

    @Override
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        City cityToDelete = session.get(City.class,city.getId());
        session.delete(cityToDelete);

    }

    @Override
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        City city = session.get(City.class,id);
        return city;
    }
}
