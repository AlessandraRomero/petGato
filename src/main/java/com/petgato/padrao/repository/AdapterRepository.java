/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.padrao.repository;

import com.petgato.configuracao.EntityManagerUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alessandra
 */
public abstract class AdapterRepository<T, K> implements Repository<T, K> {

    @PersistenceContext(unitName = "petgato")
    private  EntityManager entityManager;
    private final Class persistentClass;

    public AdapterRepository() {
        this.entityManager = EntityManagerUtil.getEntityManager();
        this.persistentClass = (Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
         entityManager = EntityManagerUtil.getEntityManager();
         return entityManager;
    }

    @Override
    public void save(T value) {
        entityManager = getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.persist(value);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }

    @Override
    public void update(T value) {
//        entityManager = getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.detach(value);
            entityManager.merge(value);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }

    @Override
    public void delete(T value) {
//        entityManager = getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.remove(value);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(K value) {
        return null;
    }
    
    public T findByName(K value){
        return null;
    }

    protected void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
