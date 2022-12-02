package com.example.classicmodelsonlineshop.repositories;

import com.example.classicmodelsonlineshop.entities.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    // Find all offices
    public List<Office> findAll() {
        return getEntityManager().createQuery("SELECT o FROM Office o", Office.class).getResultList();
    }

    //find by id
    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    //find by city or country
    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("Office.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }

    //add new office
    public boolean addOffice(Office office) {
        try {
            EntityManager entityManager = getEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //delete office by id
    public boolean delete(String officeCode) {
        try {
            EntityManager entityManager = getEntityManager();
            Office office = entityManager.find(Office.class, officeCode);

            if (office != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    //delete office by entity
    public boolean delete(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            if (office != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    //update office
    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }

}
