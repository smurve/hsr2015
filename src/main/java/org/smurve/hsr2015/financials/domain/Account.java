package org.smurve.hsr2015.financials.domain;

import org.smurve.hsr2015.books.domain.Author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

    @Id @GeneratedValue
    private long id;

    private String accountNumber;

    @ManyToOne
    private Author accountOwner;

    private double amount;

    public Account () {} // for JPA

    public Account(String accountNumber, Author accountOwner, double amount) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Author getAccountOwner() {
        return accountOwner;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
