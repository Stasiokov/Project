package com.stasio.beans;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Stasio on 19.12.2016.
 */
@Entity
@Table(name="credit",schema = "",catalog = "relationship")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Basic
    @Column(name = "idcredit")
    private int idCredit;
    @Basic
    @Column(name = "sumstartcredit")
    private long sumStartCredit;
    @Basic
    @Column(name = "sumbalance")
    private long sumBalance;
    @Basic
    @Column(name = "datestart")
    private LocalDate dateStart;
    @Basic
    @Column(name = "dateclose")
    private LocalDate dateClose;
    @Basic
    @Column(name = "currency")
    private String currency;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "idperson")
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(int idCredit) {
        this.idCredit = idCredit;
    }

    public long getSumStartCredit() {
        return sumStartCredit;
    }

    public void setSumStartCredit(long sumStartCredit) {
        this.sumStartCredit = sumStartCredit;
    }

    public long getSumBalance() {
        return sumBalance;
    }

    public void setSumBalance(long sumBalance) {
        this.sumBalance = sumBalance;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateClose() {
        return dateClose;
    }

    public void setDateClose(LocalDate dateClose) {
        this.dateClose = dateClose;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Credit() {
    }

    public Credit(Person person, int idCredit, long sumStartCredit, long sumBalance, LocalDate dateStart, LocalDate dateClose, String currency) {
        this.idCredit = idCredit;
        this.sumStartCredit = sumStartCredit;
        this.sumBalance = sumBalance;
        this.dateStart = dateStart;
        this.dateClose = dateClose;
        this.currency = currency;
        this.person = person;
    }
}
