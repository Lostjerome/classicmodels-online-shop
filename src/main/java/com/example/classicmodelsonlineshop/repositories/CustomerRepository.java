package com.example.classicmodelsonlineshop.repositories;

import com.example.classicmodelsonlineshop.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = EntityManagerBuilder.getEntityManager();
        }
        return em;
    }

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Customer.FIND_USER");
        query.setParameter("user_account", name);
        List<Customer> customers = query.getResultList();
        em.close();
        return customers.size() == 0 ? null : customers.get(0);
    }

    public Customer findByID(int id) {
        EntityManager em = getEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();
        return customer;
    }
}
