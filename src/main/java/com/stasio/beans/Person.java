package com.stasio.beans;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Stasio on 19.12.2016.
 * http://javastudy.ru/hibernate/onetomany/ - OneToMany
 */
@Entity
@Table(name = "person",schema = "",catalog = "relationship")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson", nullable = false, precision = 0)
    private int idPerson;
    @Basic
    @Column(name = "firstname", nullable = false, length = 20)
    private String firstName;
    @Basic
    @Column(name = "midlename", nullable = false, length = 20)
    private String midleName;
    @Basic
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;
//    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
    @Basic
    @Column(name = "passport", nullable = false)
    private String passport;
    @Basic
    @Column(name = "idnumber", nullable = false, length = 20)
    private String idNumber;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "person")
    private Set <Credit> credit = new HashSet<>();


    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Set<Credit> getCredit() {
        return credit;
    }

    public void setCredit(Set<Credit> credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", firstName='" + firstName + '\'' +
                ", midleName='" + midleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", passportWords='" + passport + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }

    public Person() {
    }

    public Person(String firstName, String midleName, String lastName, LocalDate birthday, String passport, String idNumber,Set <Credit> credit) {
        this.firstName = firstName;
        this.midleName = midleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.passport = passport;
        this.idNumber = idNumber;
        this.credit = credit;
    }
}
