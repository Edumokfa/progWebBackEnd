package org.example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DatabaseCommunication <T> {

    private final EntityManager entityManager;

    public DatabaseCommunication() {
        entityManager = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
    }

    public void saveOnDatabase (T data) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.merge(data);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    public T findFromDatabase(Object id){
        EntityTransaction transaction = entityManager.getTransaction();
        Object entity = null;
        try{
            transaction.begin();
            entity = entityManager.find(reflectClassType(), id);
            transaction.commit();
        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return (T) entity;
    }

    public List<T> findFromDatabase(String query){
        EntityTransaction transaction = entityManager.getTransaction();
        List<T> resultList = null;

        try{
            transaction.begin();
            resultList = entityManager.createQuery(query).getResultList();
            transaction.commit();
        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return resultList;
    }

    public void removeFromDatabase (Object id) {
        Object objectFromDb = entityManager.find(reflectClassType(), id);
        if (objectFromDb == null) {
            return;
        }
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.remove(objectFromDb);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    private Class reflectClassType() {
        return ((Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
