package org.smurve.hsr2015.books;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testFindAll () {

        Assert.assertEquals (1, bookController.findAllBooks().size());

    }

}
