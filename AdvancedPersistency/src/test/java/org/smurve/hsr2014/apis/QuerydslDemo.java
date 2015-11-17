package org.smurve.hsr2014.apis;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smurve.hsr2014.domain.books.Author;
import org.smurve.hsr2014.domain.books.Book;
import org.smurve.hsr2014.domain.books.Category;
import org.smurve.hsr2014.domain.books.QBook;
import org.smurve.hsr2014.inheritance.DatabaseTestContextWithoutCaching;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseTestContextWithoutCaching.class)
public class QuerydslDemo {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void demonstrateQueryDsl () {

        Author wolfie = new Author("Wolfie", "Giersche", Category.SCIENCE);
        entityManager.persist(wolfie);
        entityManager.persist(new Book("Myth Busting in SWE", wolfie, Category.SCIENCE, 450.00));
        entityManager.flush();

        QBook book = QBook.book;

        JPAQueryFactory factory = new JPAQueryFactory(entityManager);
        JPAQuery<?> query = factory.from(book)
                .where(book.title.contains("My")).fetchAll();
        List<?> result = query.fetch();
        Assert.assertEquals(1, result.size());
    }
}
