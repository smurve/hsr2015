package org.smurve.hsr2014.apis;

import junit.framework.Assert;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smurve.hsr2014.domain.books.Author;
import org.smurve.hsr2014.domain.books.Category;
import org.smurve.hsr2014.service.JooqBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * This class demonstrates the integration of Jooq in Spring's transaction management
 * Please see TestContext for more info
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class JooqSpringDemo {

    @Autowired
    private JooqBookService bookService;

    @Before
    public void cleanDb () {
        bookService.deleteAll();
    }

    @Test
    public void demoHappyCase () throws Exception {

        // create some data
        bookService.insertSomeValues(null);

        // and make sure it's there
        Assert.assertEquals(2, bookService.selectSomeRecords().size());
    }

    @Test
    public void demoRollbackOnRuntimeException () throws Exception {

        // Cause an exception in the middle of the transaction
        // see JooqBookService.insertSomeValues for more insight
        try {
            bookService.insertSomeValues(new RuntimeException("Something went wrong."));
            Assert.fail("Expected an exception here. Strange...");
        } catch ( Exception e ) {
            Assert.assertEquals("Something went wrong.", e.getMessage());
        }

        // Now we expect neither author nor account to be there, for they should have been rolled back
        List<Author> authors = bookService.listAuthors();

        // e voila!
        Assert.assertEquals ( 0, bookService.listAuthors().size());
    }

    /**
     * No rollback for checked exceptions -> Spring Tx Management works
     * @throws Exception
     */
    @Test
    public void demoNoRollbackOnCheckedException () throws Exception {

        // Cause an exception in the middle of the transaction
        // see JooqBookService.insertSomeValues for more insight
        try {
            bookService.insertSomeValues(new Exception("Something went wrong."));
            Assert.fail("Expected an exception here. Strange...");
        } catch ( Exception e ) {
            Assert.assertEquals("Something went wrong.", e.getMessage());
        }

        // Now we expect author and account to be there
        List<Author> authors = bookService.listAuthors();

        // e voila!
        Assert.assertEquals ( 1, bookService.listAuthors().size());

        Author author = authors.get(0);

        Assert.assertEquals(Category.FICTION, author.getCategory());
    }
}
