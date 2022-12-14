package com.example.classicmodelsonlineshop.repositories;

import com.example.classicmodelsonlineshop.entities.OrderDetail;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderDetailRepository {
    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = EntityManagerBuilder.getEntityManager();
        }
        return em;
    }

    public List<OrderDetail> findByOrderNumber(int orderNumber) {
        return getEntityManager().createQuery("SELECT od FROM OrderDetail od WHERE od.orderNumber = :orderNumber", OrderDetail.class)
                .setParameter("orderNumber", orderNumber)
                .getResultList();
    }

    public List<OrderDetail> findByProductCode(String productCode) {
        return getEntityManager().createQuery("SELECT od FROM OrderDetail od WHERE od.productCode = :productCode", OrderDetail.class)
                .setParameter("productCode", productCode)
                .getResultList();
    }

    public List<OrderDetail> findByOrderNumberAndProductCode(int orderNumber, String productCode) {
        return getEntityManager().createQuery("SELECT od FROM OrderDetail od WHERE od.orderNumber = :orderNumber AND od.productCode = :productCode", OrderDetail.class)
                .setParameter("orderNumber", orderNumber)
                .setParameter("productCode", productCode)
                .getResultList();
    }
}
