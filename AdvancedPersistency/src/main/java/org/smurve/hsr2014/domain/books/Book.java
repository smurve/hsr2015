package org.smurve.hsr2014.domain.books;

import javax.persistence.*;

@Entity
public class Book {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author author;

    private double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Book () {}

    public Book(String title, Author author, Category category, double price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() { return price; }
}
