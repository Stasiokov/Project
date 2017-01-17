package com.stasio.tools;

import com.stasio.beans.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Stasio on 23.12.2016.
 */
public class MDData {

    public static MDData mdData = new MDData();
    private  EntityManagerFactory factory;
    private  EntityManager manager;
    private ObservableList<Person> list = FXCollections.observableArrayList();

    private MDData(){
        factory = Persistence.createEntityManagerFactory("person-unit");
    }

    public static MDData getMdData() {
        return mdData;
    }

    public void startEM(){
        manager = factory.createEntityManager();
    }

    public void stopEM(){
        manager.close();
    }

    public void stopEMF(){
        factory.close();
    }

    public EntityManager getManager() {
        return manager;
    }

    public ObservableList<Person> getList() {
        return list;
    }

    public void setList(ObservableList<Person> list) {
        this.list = list;
    }
}
