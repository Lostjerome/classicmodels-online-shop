package com.example.classicmodelsonlineshop.repositories;

import com.example.classicmodelsonlineshop.entities.Employee;
import com.example.classicmodelsonlineshop.entities.Office;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    // Find all offices
    public List<Employee> findAll() {
        return getEntityManager().createQuery("SELECT o FROM Employee o", Employee.class).getResultList();
    }

    //find by id
    public Employee find(Employee employee) {
        return getEntityManager().find(Employee.class, employee);
    }

    //add new office
    public boolean addEmployee(Employee employee) {
        try {
            EntityManager entityManager = getEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //delete office by id
    public boolean delete(String employeeNumber) {
        try {
            EntityManager entityManager = getEntityManager();
            Employee employee = entityManager.find(Employee.class, employeeNumber);

            if (employee != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(employee);
                entityManager.getTransaction().commit();
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    //delete office by entity
    public boolean delete(Employee employee) {
        try {
            EntityManager entityManager = getEntityManager();
            if (employee != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(employee);
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
