package org.smurve.hsr2015.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smurve.hsr2015.books.domain.Author;
import org.smurve.hsr2015.books.domain.Book;
import org.smurve.hsr2015.books.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class BookController {

    public static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepo repo;

    @Value( "${application.title}")
    private String appName;

    @PostConstruct
    private void createInitialData() {
        LOGGER.info( appName + ": Creating initial data");
        Author wolfie = new Author("Wolfgang", "Giersche", Category.SCIENCE);
        repo.save(new Book("Wolfie's Lectures", wolfie, Category.SCIENCE));
    }

    @RequestMapping("/books")
    @ResponseBody
    public List<Book> findAllBooks() {
        List<Book> result = repo.findAll();
        LOGGER.info( appName + ": Returning the list of all books. Size: " + result.size());
        return result;
    }
}
