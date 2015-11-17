package org.smurve.hsr2014.apis;

import junit.framework.Assert;
import org.hibernate.LazyInitializationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smurve.hsr2014.domain.books.Book;
import org.smurve.hsr2014.domain.books.Book_;
import org.smurve.hsr2014.service.JpaBookService;
import org.smurve.hsr2014.service.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * This class demonstrates the usage of the CriteriaBuilder API
 * Advantage: Predicates may be built elsewhere and handed into the data access layer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceContext.class})
public class JpaAndCriteriaApiDemo {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JpaBookService bookService;

    /**
     * clean up and create some initial data
     */
    @Before
    public void createSomeData() {
        bookService.deleteAll();
        bookService.createSomeData();
    }


    /**
     * A Predicate is constructed and handed to the data access layer to retrieve the list of matches
     */
    @Test
    public void simpleDemo () {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        /** Book_ is a hand-written meta-model - usually those files are generated */
        Predicate condition = builder.gt(root.get(Book_.price), 20.00);


        List<Book> result = entityManager.createQuery(query.where(condition)).getResultList();

        Assert.assertEquals(1, result.size());
    }


    /**
     * Simple JPA Query from a String representation
     */
    @Test
    public void JPQLDemo () {
        TypedQuery<Book> query = entityManager.createQuery(
                "select alias0 from org.smurve.hsr2014.domain.books.Book as alias0 " +
                        "where alias0.price>20.0D", Book.class);

        List<Book> books = query.getResultList();

        Assert.assertEquals(1, books.size());
    }


    @Test(expected = LazyInitializationException.class)
    public void lazyInitializationDemo () {

        List<Book> books = bookService.findByTitle("Myth Busting in SWE");

        String firstName = books.get(0).getAuthor().getFirstName();

        Assert.fail("Shouldn't get here to assert on " + firstName);
    }
}
