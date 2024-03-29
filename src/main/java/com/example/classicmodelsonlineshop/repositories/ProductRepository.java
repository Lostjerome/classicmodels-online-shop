package com.example.classicmodelsonlineshop.repositories;

import com.example.classicmodelsonlineshop.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

import static com.example.classicmodelsonlineshop.repositories.EntityManagerBuilder.getEntityManager;

public class ProductRepository {
    private static int PAGE_SIZE = 10;

    public int getDefaulPageSize() {
        return PAGE_SIZE;
    }

    public Product find(String productCode) {
        return getEntityManager().find(Product.class, productCode);
    }

    public List<Product> findAll(int page) {
        return findAll(page, PAGE_SIZE);
    }

    public List<Product> findAll(int page, int pageSize) {
        int startPosition = (page - 1) * pageSize;
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("Product.FindAll");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<Product> productList = query.getResultList();
        entityManager.close();
        return productList;
    }

    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number) entityManager.createNamedQuery("Product.count").getSingleResult()).intValue();
        entityManager.close();
        return number;
    }
}
