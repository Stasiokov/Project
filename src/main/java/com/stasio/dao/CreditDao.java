package com.stasio.dao;

import com.stasio.beans.Credit;

import javax.persistence.EntityManager;

/**
 * Created by Stasio on 18.01.2017.
 */
public class CreditDao {
    private EntityManager manager;

    public CreditDao(EntityManager manager) {
        this.manager = manager;
    }

    public void insert(Credit credit) {
        manager.getTransaction().begin();
        manager.persist(credit);
        manager.getTransaction().commit();
    }
}
