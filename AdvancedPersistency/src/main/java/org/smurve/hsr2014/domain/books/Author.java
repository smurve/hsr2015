package org.smurve.hsr2014.domain.books;

import javax.persistence.*;

/**
 * an author entity
 * Created by wgiersche on 15/10/15.
 */
@Entity
public class Author {

    @Id @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Author(){}

    public Author(String firstName, String lastName, Category category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }
}
