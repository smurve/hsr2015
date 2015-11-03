package org.smurve.hsr2015.books;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smurve.hsr2015.ApplicationMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMain.class, initializers = ConfigFileApplicationContextInitializer.class)
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private ApplicationContext context;

    @Test
    public void testFindAll () {

        Assert.assertEquals (1, bookController.findAllBooks().size());
    }

    @Test
    public void verifyContext () {

        BookRepo repo = context.getBean(BookRepo.class);
        Assert.assertNotNull( repo );

        repo = (BookRepo) context.getBean("bookRepo");
        Assert.assertNotNull( repo );

    }
}
