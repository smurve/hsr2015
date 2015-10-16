package org.smurve.hsr2015.books.domain;

import javax.persistence.*;

@Entity
public class Book {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author author;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Book () {}

    public Book(String title, Author author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
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
}
