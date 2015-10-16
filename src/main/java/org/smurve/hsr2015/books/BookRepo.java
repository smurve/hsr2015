package org.smurve.hsr2015.books;

import org.smurve.hsr2015.books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
}
