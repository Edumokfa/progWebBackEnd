package org.example.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jersey-jax-rs");

    private EntityManagerFactoryUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}