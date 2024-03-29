package com.example.classicmodelsonlineshop.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerBuilder {
    private final static EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("classic-models");
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    };
}
