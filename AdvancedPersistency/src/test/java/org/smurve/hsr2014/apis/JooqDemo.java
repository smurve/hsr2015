package org.smurve.hsr2014.apis;

import com.mysql.jdbc.*;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Test;

import static org.smurve.hsr2014.jooq.Tables.*;

import java.sql.*;
import java.sql.Connection;

/**
 * An example of using a simple, yet powerful SQL Query framework
 * Note that everything takes place on the Jdbc Connection with auto-commit enabled
 */
public class JooqDemo {

    /**
     * This test demonstrates a simple but typesafe select statement on the mysql database
     */
    @Test
    public void demoSimpleRetrieval() {

        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/hsr2015";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {

            DSLContext ctx = DSL.using(conn, SQLDialect.MYSQL);

            deleteAll(ctx);

            insertSomeValues(ctx);

            Result<Record> books = selectSomeRecords(ctx);

            assertTitles(books);

        } catch (Exception e) {

            // For the sake of this tutorial, let's keep exception handling simple
            e.printStackTrace();
        }
    }
    /**/

    /**
     * Assert that the two records actually show up in the result list
     */
    private void assertTitles(Result<Record> books) {
        Assert.assertTrue(books.stream().anyMatch((b) -> b.getValue(BOOK.TITLE).startsWith("My")));
        Assert.assertTrue(books.stream().anyMatch((b) -> b.getValue(BOOK.TITLE).startsWith("Your")));
    }
    /* */

    /**
     * Select all book titles starting with "My" or "Your"
     * @param ctx the DSL Context to use
     * @return the resulting list of records
     */
    private Result<Record> selectSomeRecords(DSLContext ctx) {
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
     * insert some test records
     * @param ctx the DSL Context to use
     */
    private void insertSomeValues(DSLContext ctx) {
        ctx.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRSTNAME, AUTHOR.LASTNAME, AUTHOR.CATEGORY)
                .values(10L, "Harry", "Hirsch", "Fiction").execute();

        ctx.insertInto(ACCOUNT, ACCOUNT.ID, ACCOUNT.ACCOUNTNUMBER, ACCOUNT.ACCOUNTOWNER_ID, ACCOUNT.AMOUNT)
                .values(11L, "SAVINGS001", 10L, 1500.00).execute();

        ctx.insertInto(BOOK, BOOK.ID, BOOK.AUTHOR_ID, BOOK.TITLE, BOOK.PRICE, BOOK.CATEGORY)
                .values(12L, 10L, "My little farm", 145.00, "Poetry").execute();

        ctx.insertInto(BOOK, BOOK.ID, BOOK.AUTHOR_ID, BOOK.TITLE, BOOK.PRICE, BOOK.CATEGORY)
                .values(13L, 10L, "Your little farm", 146.00, "Poetry").execute();
    }
    /**/

    /**
     * Simply execute a SQL DELETE
     * @param ctx the DSL Context to use
     */
    private void deleteAll(DSLContext ctx) {
        ctx.deleteFrom(BOOK).execute();
        ctx.deleteFrom(ACCOUNT).execute();
        ctx.deleteFrom(AUTHOR).execute();
    }
    /**/

}