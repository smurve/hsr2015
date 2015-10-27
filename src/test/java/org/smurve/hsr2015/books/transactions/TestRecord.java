package org.smurve.hsr2015.books.transactions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 */
@Entity
public class TestRecord {

    @Id
    @GeneratedValue
    private Long id;

    private String innerOrOuter;
    private String firstArg;
    private String secondArg;

    public TestRecord () {} // for JPA

    public TestRecord(String innerOrOuter, String firstArg, String secondArg) {
        this.innerOrOuter = innerOrOuter;
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    public Long getId() {
        return id;
    }
    public String getInnerOrOuter() {
        return innerOrOuter;
    }

    public String getFirstArg() {
        return firstArg;
    }

    public String getSecondArg() {
        return secondArg;
    }

}
