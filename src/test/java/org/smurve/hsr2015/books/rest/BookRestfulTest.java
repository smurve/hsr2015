package org.smurve.hsr2015.books.rest;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smurve.hsr2015.ApplicationMain;
import org.smurve.hsr2015.books.domain.Book;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMain.class,
        initializers = ConfigFileApplicationContextInitializer.class)
@WebIntegrationTest
public class BookRestfulTest {

    RestTemplate template = new TestRestTemplate();

    @Test
    public void testBookService () {
        Book[] result = template.getForObject("http://localhost:8080/books", Book[].class);

        Assert.assertEquals(1, result.length);
    }

}
