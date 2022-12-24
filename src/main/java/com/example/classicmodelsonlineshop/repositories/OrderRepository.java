package com.example.classicmodelsonlineshop.repositories;

import com.example.classicmodelsonlineshop.entities.Order;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public Order find(int orderNumber) {
        return getEntityManager().find(Order.class, orderNumber);
    }

    public List<Order> findByCustomerNumber(int customerNumber) {
        return getEntityManager().createQuery("SELECT o FROM Order o WHERE o.customerNumber = :customerNumber", Order.class)
                .setParameter("customerNumber", customerNumber)
                .getResultList();
    }

}
