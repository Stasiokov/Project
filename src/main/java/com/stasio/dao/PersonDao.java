package com.stasio.dao;

import com.stasio.beans.Person;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Stasio on 23.12.2016.
 */
public class PersonDao {
    private EntityManager manager;

    public PersonDao(EntityManager manager) {
        this.manager = manager;
    }

    public void insert(Person person) {
        manager.getTransaction().begin();
        manager.persist(person);
        manager.getTransaction().commit();
    }

    public Person get(int i){
        return manager.find(Person.class,i);
    }

    public List<Person>getAll(){
        List<Person> personAll = null;
        manager.getTransaction().begin();
        personAll = manager.createNativeQuery("SELECT * FROM person",Person.class).getResultList();
        manager.getTransaction().commit();
        return personAll;
    }

    public Person search(String str){
        return null;
    }
}
