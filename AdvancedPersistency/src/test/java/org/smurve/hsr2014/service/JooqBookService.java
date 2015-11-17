package org.smurve.hsr2014.service;


import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.Result;
import org.smurve.hsr2014.domain.books.Author;
import org.smurve.hsr2014.domain.books.Category;
import org.smurve.hsr2014.jooq.tables.records.AuthorRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.util.List;

import static org.smurve.hsr2014.jooq.Tables.ACCOUNT;
import static org.smurve.hsr2014.jooq.Tables.AUTHOR;
import static org.smurve.hsr2014.jooq.Tables.BOOK;

@Transactional
public class JooqBookService {

    @Autowired
    private DSLContext ctx;

    /**
     * Select all book titles starting with "My" or "Your"
     * @return the resulting list of records
     */
    public Result<Record> selectSomeRecords() {
        return ctx.select().from(BOOK).join(AUTHOR).on(BOOK.AUTHOR_ID.equal(AUTHOR.ID))
                .where(
                        BOOK.AUTHOR_ID.equal(10L))
                .and(
                        BOOK.TITLE.startsWith("My")
                                .or(BOOK.TITLE.startsWith("Your")))
                .and(AUTHOR.LASTNAME.contains("irsch"))
                .fetch();
    }
    /**/

    /**
     * insert some test records and throw an Exception if provided (THIS IS DEMO CODE!!!)
     */
    public void insertSomeValues( Exception rte) throws  Exception {
        ctx.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRSTNAME, AUTHOR.LASTNAME, AUTHOR.CATEGORY)
                .values(10L, "Harry", "Hirsch", "FICTION").execute();

        ctx.insertInto(ACCOUNT, ACCOUNT.ID, ACCOUNT.ACCOUNTNUMBER, ACCOUNT.ACCOUNTOWNER_ID, ACCOUNT.AMOUNT)
                .values(11L, "SAVINGS001", 10L, 1500.00).execute();

        if ( rte != null ) {
            throw rte;
        }

        ctx.insertInto(BOOK, BOOK.ID, BOOK.AUTHOR_ID, BOOK.TITLE, BOOK.PRICE, BOOK.CATEGORY)
                .values(12L, 10L, "My little farm", 145.00, "POETRY").execute();

        ctx.insertInto(BOOK, BOOK.ID, BOOK.AUTHOR_ID, BOOK.TITLE, BOOK.PRICE, BOOK.CATEGORY)
                .values(13L, 10L, "Your little farm", 146.00, "POETRY").execute();
    }
    /**/

    /**
     * Simply execute a SQL DELETE
     */
    public void deleteAll() {
        ctx.deleteFrom(BOOK).execute();
        ctx.deleteFrom(ACCOUNT).execute();
        ctx.deleteFrom(AUTHOR).execute();
    }


    public List<Author> listAuthors() {

        return ctx.select().from(AUTHOR).fetch(getAuthorMapper());
    }


    public RecordMapper<Record, Author> getAuthorMapper () {
        return rec -> {
            AuthorRecord record = (AuthorRecord) rec;
            Author author = new Author(record.getFirstname(), record.getLastname(), Category.valueOf(record.getCategory()));
            author.setId(record.getId());
            return author;
        };
    }
}
