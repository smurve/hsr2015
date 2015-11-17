package org.smurve.hsr2014.service;

import org.smurve.hsr2014.domain.books.Author;
import org.smurve.hsr2014.domain.books.Book;
import org.smurve.hsr2014.domain.books.Category;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class JpaBookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Book> findByTitle ( String title ) {

        TypedQuery<Book> query = entityManager.createQuery(
                "from Book b where b.title = :title", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    public void createSomeData() {
        Author wolfie = new Author("Wolfie", "Giersche", Category.SCIENCE);
        entityManager.persist(wolfie);
        entityManager.persist(new Book("Myth Busting in SWE", wolfie, Category.SCIENCE, 450.00));
        entityManager.flush();
        entityManager.clear(); // no entries in the cache
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("delete from Book").executeUpdate();
        entityManager.createQuery("delete from Account").executeUpdate();
        entityManager.createQuery("delete from Author").executeUpdate();
    }
}
