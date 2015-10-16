package org.smurve.hsr2015.books;

import org.smurve.hsr2015.books.domain.Author;
import org.smurve.hsr2015.books.domain.Book;
import org.smurve.hsr2015.books.domain.Category;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple in-memory Repo
 * Created by wgiersche on 15/10/15.
 */
@Component
public class BookTestRepo {

    private final List<Book> database = new ArrayList<>();

    @PostConstruct
    private void createInitialData() {
        Author wolfie = new Author("Wolfgang", "Giersche", Category.SCIENCE);
        database.add(new Book("Wolfie's Lectures", wolfie, Category.SCIENCE));
    }

    /**
     *
     * @return all books in the database
     */
    public List<Book> findAll() {
        List<Book> defensiveCopy = new ArrayList<>(1);
        database.stream().forEach(defensiveCopy::add);
        return defensiveCopy;
    }
}
